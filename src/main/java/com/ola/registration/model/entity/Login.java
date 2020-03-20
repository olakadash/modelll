package com.ola.registration.model.entity;

import java.sql.Date;
import java.time.LocalDateTime;

public class Login {

    private String studentId;
    private String token;
    private LocalDateTime time;

    public Login(String studentId, String token, LocalDateTime time) {
        this.studentId = studentId;
        this.token = token;
        this.time = time;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Login{" +
                "studentId='" + studentId + '\'' +
                ", token='" + token + '\'' +
                ", time=" + time +
                '}';
    }
}
