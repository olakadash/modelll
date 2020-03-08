package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.CourseDAO;
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
    public String findCourseById(String id)  {

        String result=" ";

        try {
        String query = " select * from courses.course where id=?";

        ResultSet resultSet =  databaseConnection.select(query,id);

        while (resultSet.next()){

            result=resultSet.getString(1);

        }

        }catch (Exception e){
            System.out.println(e);
        }

        return result;
    }

    @Override
    public String findCourseByName(String courseName)  {
        String result=" ";

        try {
        String query = " select * from courses.course where courseName=?";

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
        String query = " select * from courses.course where instructor=?";

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

        String query = " insert into courses.course values(?,?,?,?,?,?,?,?)";
        databaseConnection.insertCourse(query,course);

    }

    @Override
    public List<Course> list() {

        return null;
    }

    @Override
    public void update(Course course)  {

        String query = " update  courses.course set courseName=? ,instructor=?, courseCode=?, capacity=?, startingDate=? ,duration =?, hours=? where id=? ;";

        databaseConnection.updateCourse(query,course);

    }

    @Override
    public boolean deleteCourseById(String id) {

        String query = " delete from courses.course where id=?";

      return  databaseConnection.delete(query , id);


    }
}
