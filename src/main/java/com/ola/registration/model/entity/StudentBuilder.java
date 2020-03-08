package com.ola.registration.model.entity;

public class StudentBuilder {

        Student student;

        public StudentBuilder() {

            student=new Student();
        }


        public StudentBuilder setIdBuilder(String id){
            student.setId(id);
            return this;
        }


    public StudentBuilder setFirstNameBuilder(String firstName){
        student.setFirstName(firstName);
        return this;
    }


    public StudentBuilder setLastNameBuilder(String lastName){
        student.setLastName(lastName);
        return this;
    }


    public StudentBuilder setEmailBuilder(String email){
        student.setEmail(email);
        return this;
    }


    public StudentBuilder setPasswordBuilder(String password){
        student.setPassword(password);
        return this;
    }

    public StudentBuilder setJoinYearBuilder(String joinYear){
        student.setJoinYear(joinYear);
        return this;
    }

    public Student build(){

        return student;
    }




}
