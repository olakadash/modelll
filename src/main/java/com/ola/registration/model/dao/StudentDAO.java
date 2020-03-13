package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Student;



public interface StudentDAO {

    Student   findById(String ID) ;
    //ToDO make method return Student
    String    findByEmail(String email) ;
    void      save(Student student);
    void      update(Student student) ;
    boolean   deleteStudentById(String ID);

}
