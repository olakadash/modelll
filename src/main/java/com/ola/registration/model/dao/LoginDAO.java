package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Login;

import java.time.LocalDateTime;


public interface LoginDAO {

    void      save(Login login);
    boolean   isAlive(String token,String studentId);
    boolean   deleteLogged(String studentId);
    boolean   isLogged(String userId);

}
