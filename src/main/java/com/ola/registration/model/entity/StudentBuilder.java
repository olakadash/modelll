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


    public StudentBuilder setFirstNameBuilder(String firstname){
        student.setFirstName(firstname);
        return this;
    }


    public StudentBuilder setLastNameBuilder(String lastname){
        student.setLastName(lastname);
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

    public StudentBuilder setJoinBuilder(String joinYear){
        student.setJoinYear(joinYear);
        return this;
    }

    public Student build(){

        return student;
    }




}
