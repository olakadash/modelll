package com.ola.registration.model.entity;

import java.util.Date;

public class CourseBuilder {

    Course course;

    public CourseBuilder() {

         course=new Course();
    }


    public CourseBuilder setCourseIdBuilder(String id) {
        course.setCourseId(id);
        return this;
    }


    public CourseBuilder setCourseNameBuilder(String name) {
        course.setCourseName(name);
        return this;
    }


    public CourseBuilder setInstructorBuilder(String instructor) {
        course.setInstructor(instructor);
        return this;
    }

    public CourseBuilder setCourseCodeBuilder(String courseCode) {
        course.setCourseCode(courseCode);
        return this;
    }

    public CourseBuilder setCapacityBuilder(Double capacity) {

        course.setCapacity(capacity);

        return this;
    }


    public CourseBuilder setStartingDateBuilder(Date startingDate) {
        course.setStartingDate(startingDate);
        return this;
    }

    public CourseBuilder setDurationBuilder(String duration) {
        course.setDuration(duration);
        return this;
    }

    public CourseBuilder setHoursBuilder(String hours) {
        course.setHours(hours);
        return this;
    }



    public Course build(){

        return course;
    }

}
