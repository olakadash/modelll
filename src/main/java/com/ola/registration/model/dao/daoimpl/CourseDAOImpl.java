package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.CourseDAO;
import com.ola.registration.model.entity.BuildCourseBuilderConstructor;
import com.ola.registration.model.utils.DatabaseConnection;
import com.ola.registration.model.entity.Course;
import java.sql.ResultSet;
import java.util.List;

public class CourseDAOImpl implements CourseDAO  {

    private DatabaseConnection databaseConnection;

    public CourseDAOImpl(String url , String username, String password)  {
        databaseConnection =new DatabaseConnection(url, username, password);

    }



    @Override
    public Course findCourseById(String id)  {

        Course course=null;

        try {
        String query = " select * from student1.course where idCourse=?";

        ResultSet resultSet =  databaseConnection.select(query,id);

        if (resultSet.next()){

            course= BuildCourseBuilderConstructor.buildCourseFromResultSET(resultSet);

        }

        }catch (Exception e){
            System.out.println(e);
        }

        return course;
    }

    @Override
    public String findCourseByName(String courseName)  {
        String result=" ";

        try {
        String query = " select * from student1.course where courseName=?";

        ResultSet resultSet =  databaseConnection.select(query,courseName);

        while (resultSet.next()) {
            result= resultSet.getString(2);
        }
        }catch (Exception e){
            System.out.println(e); }

        return result;
    }

    @Override
    public String findCourseByInstructor(String instructor)  {

        String result=" ";
        try {
        String query = " select * from student1.course where instructor=?";

        ResultSet resultSet =  databaseConnection.select(query,instructor);

        while (resultSet.next()) {
             result= resultSet.getString(3) ;

        }
    }catch (Exception e){
        System.out.println(e); }

        return result;
    }

    @Override
    public void save(Course course) {

        String query = " insert into student1.course values(?,?,?,?,?,?,?,?)";
        databaseConnection.insertCourse(query,course);

    }

    @Override
    public List<Course> list() {

        return null;
    }

    @Override
    public void update(Course course)  {
        //ToDO handel update query

        String query = " update  student1.course set courseName=? ,instructor=?, courseCode=?, capacity=?, startingDate=? ,duration =?, hours=? where idcourse=? ;";

        databaseConnection.updateCourse(query,course);

    }

    @Override
    public boolean deleteCourseById(String id) {

        String query = " delete from student1.course where idcourse=?";

      return  databaseConnection.delete(query , id);


    }
}
