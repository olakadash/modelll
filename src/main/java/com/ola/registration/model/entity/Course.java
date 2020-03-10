package com.ola.registration.model.entity;

public class Course {

    private  String courseId;
    private  String courseName;
    private  String instructor;
    private  String courseCode;
    private  String capacity;
    private  String startingDate;
    private  String duration ;
    private  String hours;



     void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getHours() {
        return hours;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", capacity='" + capacity + '\'' +
                ", startingDate='" + startingDate + '\'' +
                ", duration='" + duration + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}
