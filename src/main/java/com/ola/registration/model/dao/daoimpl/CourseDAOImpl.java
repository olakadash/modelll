package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.CourseDAO;
import com.ola.registration.model.utils.DatabaseConnection;
import com.ola.registration.model.entity.Course;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAOImpl implements CourseDAO  {

    private DatabaseConnection databaseConnection;

    public CourseDAOImpl(String url , String username, String password) throws SQLException {
        databaseConnection =new DatabaseConnection(url, username, password);

    }



    @Override
    public void findCourseById(String id)  {
        try {


        String query = " select * from courses.course "
                + "where id=?";

        ResultSet resultSet =  databaseConnection.select(query,id);

        while (resultSet.next()){

            System.out.println("CourseIdFound:- "+resultSet.getString(1)+
                    "\n info :"  +
                    "\ncourseName:- "+resultSet.getString(2)+
                    "\ninstructorName:- "+ resultSet.getString(3)+"\n");

        }

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void findCourseByName(String courseName)  {
        try {
        String query = " select * from courses.course "
                + "where courseName=?";

        ResultSet resultSet =  databaseConnection.select(query,courseName);

        while (resultSet.next()) {
            System.out.println("\n courseFound "+ resultSet.getString(2) +"\n Other Info:- "+
                    "\n ID:- "+resultSet.getString(1)  +
                    "\n instructorName:- "+resultSet.getString(3)+"\n");
        }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void findCourseByInstructor(String instructor)  {
        try {
        String query = " select * from courses.course "
                + "where instructor=?";

        ResultSet resultSet =  databaseConnection.select(query,instructor);

        while (resultSet.next()) {
            System.out.println("\n instructorFound "+ resultSet.getString(3) +"\n Other Info:- "+
                    "\n ID:- "+resultSet.getString(1)  +
                    "\n courseName:- "+resultSet.getString(2)+"\n");
        }
    }catch (SQLException e){
        System.out.println(e);
    }
    }

    @Override
    public void save(Course course) {

        String query = " insert into courses.course " +" values(?,?,?)";
        databaseConnection.insertCourse(query,course);

    }

    @Override
    public void list() {

    }

    @Override
    public void update(Course course)  {

        String query = " update  courses.course " +" set courseName=? ,instructor=? where id=? ;";

        databaseConnection.updateCourse(query,course);

    }

    @Override
    public void deleteCourseById(String id) {
        String query = " delete from courses.course where id=?";

        databaseConnection.delete(query , id);

    }
}
