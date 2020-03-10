package com.ola.registration.model.entity;

import java.sql.ResultSet;

public class BuildCourseBuilderConstructor {


    public static Course buildCourseFromUserInput(String id , String courseName, String instructor, String courseCode,
                                       String capacity,String startingDate,String duration,String hours){

        return new CourseBuilder().setCourseIdBuilder(id).setCourseNameBuilder(courseName).
                setInstructorBuilder(instructor).setCourseCodeBuilder(courseCode).setCapacityBuilder(capacity).
                setStartingDateBuilder(startingDate).setDurationBuilder(duration).setHoursBuilder(hours).build();
    }

    public static Course buildCourseFromResultSET(ResultSet resultSet) {

        Course course=null;

        try {

            course =new CourseBuilder().setCourseIdBuilder(resultSet.getString(1)).
             setCourseNameBuilder(resultSet.getString(2)).setInstructorBuilder(resultSet.getString(3)).
             setCourseCodeBuilder(resultSet.getString(4)).setCapacityBuilder(resultSet.getString(5)).
             setStartingDateBuilder(resultSet.getString(6)).setDurationBuilder(resultSet.getString(7)).
             setHoursBuilder(resultSet.getString(8)).build();

        } catch (Exception e) {
            System.out.println(e);
        }

        return course;
    }
}
