package com.ola.registration.model.entity;

public class NewStudentBuilder {


    public static Student creatStudent(String id , String firstName, String lastName, String email, String password,
                                       String joinYear){

    Student  newStudent= new StudentBuilder().setIdBuilder(id).setFirstNameBuilder(firstName).setLastNameBuilder(lastName).
                               setEmailBuilder(email).setPasswordBuilder(password).setJoinYearBuilder(joinYear).build();

        return newStudent;
    }
}
