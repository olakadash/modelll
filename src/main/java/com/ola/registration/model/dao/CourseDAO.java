package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Course;
import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {

    String        findCourseById(String id) ;
    String        findCourseByName(String courseName) ;
    String        findCourseByInstructor(String instructor) ;
    void          save(Course course);
    List<Course>  list();
    void          update(Course course) ;
    boolean       deleteCourseById(String id);

}
