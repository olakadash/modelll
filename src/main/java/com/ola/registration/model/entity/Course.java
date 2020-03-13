package com.ola.registration.model.entity;


import java.util.Date;

public class Course {

    private  String courseId;
    private  String courseName;
    private  String instructor;
    private  String courseCode;
    private  Double capacity;
    private  Date   startingDate;
    private  String duration ;
    private  String hours;


    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public void setStartingDate(Date startingDate) {
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

    public Double getCapacity() {
        return capacity;
    }

    public Date getStartingDate() {
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
