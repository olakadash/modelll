package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Student;

import java.sql.SQLException;

public interface StudentDAO {

    void findById(String ID) ;
    void findByEmail(String email) ;
    void save(Student student);
    void update(Student student) ;
    void delete(String ID);

}
