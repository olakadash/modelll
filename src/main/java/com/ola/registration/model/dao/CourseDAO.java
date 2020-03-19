package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Course;
import java.util.List;

public interface CourseDAO {

    Course         findCourseById(String id) ;
    Course         findCourseByName(String courseName) ;
    List<Course>   findCourseByInstructor(String instructor) ;
    void           save(Course course);
    List<Course>   listOfCourse();
    void           update(Course course) ;
    boolean        deleteCourseById(String id);

}
