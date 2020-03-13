package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Course;
import java.util.List;

public interface CourseDAO {

    Course        findCourseById(String id) ;
    //ToDO make method return Course
    String        findCourseByName(String courseName) ;
    //ToDO make method return list of course for that instructor
    String        findCourseByInstructor(String instructor) ;
    void          save(Course course);
    //ToDO make method return List of Course
    List<Course>  list();
    void          update(Course course) ;
    boolean       deleteCourseById(String id);

}
