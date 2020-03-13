package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.ScheduleDAO;
import com.ola.registration.model.entity.*;
import com.ola.registration.model.utils.DatabaseConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    private DatabaseConnection databaseConnection;
    private ResultSet resultSet;
    private String query,query2;

    public ScheduleDAOImpl(String url , String username, String password)  {
        databaseConnection =new DatabaseConnection(url, username, password);

    }
    @Override
    public List<Student> findByCourseId(String courseId) {

        List<Student> schedules =new ArrayList<>();

      //  query= " select * from student1.schedule inner join student1.course on (schedule.idCourse = course.courseId)where schedule.idCourse= ? ;";

        query2="select id , firstName ,lastName,email,password,joinYear from student1.schedule inner join student1.course on (schedule.idCourse = course.courseId)" +
               "Inner Join  student1.student on ( schedule.idStudent = student.id)" +
               "where schedule.idCourse=?;";

      resultSet= databaseConnection.select(query2,courseId);

     try{
         int i=0;
     while (resultSet.next()) {

         schedules.add(BuildStudentBuilderConstructor.buildStudentFromResultSET(resultSet));
         System.out.println(schedules.get(i).toString());
         i+=1;
     }

     }catch (Exception e){
         e.getStackTrace();
     }

     return schedules;
    }

    @Override
    public List<Course> findByStudentId(String studentId) {
        List<Course> studentSchedule =new ArrayList<>();

       //  query= " select * from student1.schedule inner join student1.student on (schedule.idStudent = student.Id) where schedule.idStudent= ? ;";

        query2="select courseId,courseName,instructor,courseCode,capacity,startingDate,duration,hours from student1.schedule inner join student1.student on (schedule.idStudent = student.id)" +
                "Inner Join  student1.course on ( schedule.idCourse = course.courseId)" +
                "where schedule.idStudent=?;";

         resultSet= databaseConnection.select(query2,studentId);

        try{

       while (resultSet.next()) {

        studentSchedule.add(BuildCourseBuilderConstructor.buildCourseFromResultSET(resultSet));
       }

        }catch (Exception e){
            e.getStackTrace();
        }
        return studentSchedule;
    }

    @Override
    public boolean deleteSchedule(String id) {

         query="delete from student1.schedule where (idSchedule= ?);";

         return databaseConnection.delete(query,id);


    }

    @Override
    public void saveNewSchedule(Schedule schedule) {

       query="insert into student1.schedule(idSchedule,idStudent,idCourse) values (?,?,?);";

      databaseConnection.insertSchedule(query,schedule);

    }

    @Override
    public void updateSchedule() {

    }

    @Override
    public String scheduleIdCreator() {
        int scheduleId;
        boolean validId=false;

        scheduleId= 1 +(int)(Math.random()*(1000-1+1));
         try {

             do {

                 String query = " select idSchedule from student1.schedule ;";

                 ResultSet resultSet = databaseConnection.selectColumn(query);

                 while (resultSet.next()) {

                     int checkId = Integer.parseInt(resultSet.getString(1));

                     if (scheduleId == checkId) {

                         scheduleId = 1 + (int) (Math.random() * (1000 - 1 + 1));

                         validId = true;

                     } else {
                         validId = false;

                     }
                 }

             } while (validId);

         }catch (Exception e){
             e.getStackTrace();
         }

         return String.valueOf(scheduleId);
    }

    @Override
    public boolean isRegister(String studentId, String courseId) {

        query="select * from student1.schedule where idStudent=? and idCourse=? ; ";

        boolean result=false;

         resultSet= databaseConnection.selectRegistration(query,studentId,courseId);

          try {

        if (resultSet.next()){

            result= true;
        }

        else {
            result=false; }

       }catch (Exception e){
              e.getStackTrace();
          }

          return result;
    }
}