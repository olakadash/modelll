package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Course;
import java.sql.SQLException;

public interface CourseDAO {

    void findCourseById(String id) ;
    void findCourseByName(String courseName) ;
    void findCourseByInstructor(String instructor) ;
    void save(Course course);
    void list();
    void update(Course course) ;
    void deleteCourseById(String id);

}
