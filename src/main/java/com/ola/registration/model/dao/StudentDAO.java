package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Student;



public interface StudentDAO {

    Student   findById(String ID) ;
    Student   findByEmail(String email) ;
    void      save(Student student);
    void      update(Student student) ;
    boolean   deleteStudentById(String ID);
    boolean   authenticateUser(String studentId,String password);

}
