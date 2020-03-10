package com.ola.registration.model.entity;

import java.sql.ResultSet;

public class BuildStudentBuilderConstructor {


    public static Student buildStudentFromUserInput(String id , String firstName, String lastName, String email, String password,
                                       String joinYear){

        return new StudentBuilder().setIdBuilder(id).setFirstNameBuilder(firstName).setLastNameBuilder(lastName).
                                   setEmailBuilder(email).setPasswordBuilder(password).setJoinYearBuilder(joinYear).build();
    }

    public static Student buildStudentFromResultSET(ResultSet resultSet) {

        Student student=null;

        try {

             student =new StudentBuilder().setIdBuilder(resultSet.getString(1)).
                    setFirstNameBuilder(resultSet.getString(2)).setLastNameBuilder(resultSet.getString(3)).
                    setEmailBuilder(resultSet.getString(4)).setPasswordBuilder(resultSet.getString(5))
                    .setJoinYearBuilder(resultSet.getString(6)).build();

        } catch (Exception e) {
            System.out.println(e);
        }

        return student;
    }
}
