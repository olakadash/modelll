package com.ola.registration.model.entity;

public class CourseBuilder {

    Course course;

    public CourseBuilder() {

         course=new Course();
    }

    public CourseBuilder setIdBuilder(String id){

        course.setId(id);

        return this;
    }

    public CourseBuilder setCapacityBuilder(String capacity) {
        course.setCapacity(capacity);

        return this;
    }


    public CourseBuilder setStartingDateBuilder(String startingDate) {
        course.setStartingDate(startingDate);
        return this;
    }

    public CourseBuilder setDurationBuilder(String duration) {
        course.setDuration(duration);
        return this;
    }

    public CourseBuilder setHoursBuilder (String hours) {
        course.setHours(hours);
        return this;
    }


    public CourseBuilder setId(String id) {
        course.setId(id);
        return this;
    }

    public CourseBuilder setCourseCode(String courseCode) {
        course.setCourseCode(courseCode);
        return this;
    }
    public CourseBuilder setCourseName(String name) {
        course.setCourseName(name);
        return this;
    }

    public CourseBuilder setInstructorBuilder(String instructor) {
        course.setInstructor(instructor);
        return this;
    }

    public Course build(){

        return course;
    }

}
