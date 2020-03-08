package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Student;



public interface StudentDAO {

    String   findById(String ID) ;
    String   findByEmail(String email) ;
    void     save(Student student);
    void     update(Student student) ;
    boolean  deleteStudentById(String ID);

}
