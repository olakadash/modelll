package com.ola.registration.model.entity;

public class NewCourseBuilder {


    public static Course creatCourse(String id , String courseName, String instructor, String courseCode,
                                       String capacity,String startingDate,String duration,String hours){

        Course  newCourse= new CourseBuilder().setCourseIdBuilder(id).setCourseNameBuilder(courseName).
                setInstructorBuilder(instructor).setCourseCodeBuilder(courseCode).setCapacityBuilder(capacity).
                setStartingDateBuilder(startingDate).setDurationBuilder(duration).setHoursBuilder(hours).build();

        return newCourse;
    }
}
