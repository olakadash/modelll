package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.ScheduleDAO;
import com.ola.registration.model.entity.*;
import com.ola.registration.model.utils.DatabaseConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    private DatabaseConnection databaseConnection;

    public ScheduleDAOImpl(String url , String username, String password)  {
        databaseConnection =new DatabaseConnection(url, username, password);

    }
    @Override
    public List<Student> findByCourseId(String courseId) {

        List<Student> schedules =new ArrayList<>();

      // String query= " select * from student1.schedule inner join student1.course on (schedule.idCourse = course.courseId)where schedule.idCourse= ? ;";

       String query2="select id , firstName ,lastName,email,password,joinYear from student1.schedule inner join student1.course on (schedule.idCourse = course.courseId)" +
               "Inner Join  student1.student on ( schedule.idStudent = student.id)" +
               "where schedule.idCourse=?;";

    ResultSet resultSet= databaseConnection.select(query2,courseId);

     try{

     while (resultSet.next()) {

         schedules.add(BuildStudentBuilderConstructor.buildStudentFromResultSET(resultSet));

     }

     }catch (Exception e){
         e.getStackTrace();
     }

     return schedules;
    }

    @Override
    public List<Course> findByStudentId(String studentId) {
        List<Course> studentSchedule =new ArrayList<>();

       // String query= " select * from student1.schedule inner join student1.student on (schedule.idStudent = student.Id) where schedule.idStudent= ? ;";

        String query2="select courseId,courseName,instructor,courseCode,capacity,startingDate,duration,hours from student1.schedule inner join student1.student on (schedule.idStudent = student.id)" +
                "Inner Join  student1.course on ( schedule.idCourse = course.courseId)" +
                "where schedule.idStudent=?;";

        ResultSet result= databaseConnection.select(query2,studentId);

        try{

       while (result.next()) {

        studentSchedule.add(BuildCourseBuilderConstructor.buildCourseFromResultSET(result));
       }

        }catch (Exception e){
            e.getStackTrace();
        }
        return studentSchedule;
    }

    @Override
    public boolean deleteSchedule(String id) {

        String query="delete from student1.schedule where (scheduleId= ?);";

         return databaseConnection.delete(query,id);


    }

    @Override
    public void saveNewSchedule(Schedule schedule) {

      String query="insert into student1.schedule(idStudent,idCourse,scheduleId) values (?,?,?);";

      databaseConnection.insertSchedule(query,schedule);

    }

    @Override
    public void updateSchedule() {

    }
}