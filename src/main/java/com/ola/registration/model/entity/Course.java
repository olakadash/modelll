package com.ola.registration.model.entity;

public class Course {

    private  String id;
    private  String courseName;
    private  String instructor;
    private  String courseCode;
    private  String Capacity;
    private  String startingDate;
    private  String duration ;
    private  String hours;



    public void setCapacity(String capacity) {
        Capacity = capacity;
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

    public void setId(String id) {
        this.id = id;
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

    public String getId() {
        return id;
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
        return Capacity;
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

}
