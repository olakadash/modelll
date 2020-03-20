package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.CourseDAO;
import com.ola.registration.model.entity.BuildCourseBuilderConstructor;
import com.ola.registration.model.utils.DatabaseConnection;
import com.ola.registration.model.entity.Course;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        String query = " select * from student1.course where courseId=?";

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
    public Course findCourseByName(String courseName)  {
        Course course=null;

        try {
        String query = " select * from student1.course where courseName=?";

        ResultSet resultSet =  databaseConnection.select(query,courseName);

        while (resultSet.next()) {
            course= BuildCourseBuilderConstructor.buildCourseFromResultSET(resultSet);
        }
        }catch (Exception e){
            System.out.println(e); }

        return course;
    }

    @Override
    public List<Course> findCourseByInstructor(String instructor)  {

        List<Course> listOfInstructorCode=new ArrayList<>();

        try {
        String query = " select * from student1.course where instructor=?";

        ResultSet resultSet =  databaseConnection.select(query,instructor);

        while (resultSet.next()) {

            listOfInstructorCode.add(BuildCourseBuilderConstructor.buildCourseFromResultSET(resultSet));

        }
    }catch (Exception e){
        System.out.println(e); }

        return listOfInstructorCode;
    }

    @Override
    public void save(Course course) {

        String query = " insert into student1.course values(?,?,?,?,?,?,?,?)";
        databaseConnection.insertCourse(query,course);

    }

    @Override
    public List<Course> listOfCourse() {

        List<Course> listOfCourse=new ArrayList<>();

        String query="select * from student1.course ";

        ResultSet resultSet=databaseConnection.selectColumn(query);
        try {


            while (resultSet.next()) {

                listOfCourse.add(BuildCourseBuilderConstructor.buildCourseFromResultSET(resultSet));

            }
        }catch (Exception e){
            e.getStackTrace();
        }

        return listOfCourse;
    }

    @Override
    public void update(Course course)  {
        //ToDO handel update query

        String query = " update  student1.course set courseName=? ,instructor=?, courseCode=?, capacity=?, startingDate=? ,duration =?, hours=? where idCourse=? ;";

        databaseConnection.updateCourse(query,course);

    }

    @Override
    public boolean deleteCourseById(String id) {

        String query = " delete from student1.course where courseId=?";

      return  databaseConnection.delete(query , id);


    }
}
