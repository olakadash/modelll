package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.LoginDAO;
import com.ola.registration.model.entity.Login;
import com.ola.registration.model.utils.DatabaseConnection;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {

    private DatabaseConnection databaseConnection;

    public LoginDAOImpl(String url,String userName,String password) {

        this.databaseConnection=new DatabaseConnection(url,userName,password);

    }

    @Override
    public void save(Login login) {

        String query="insert into student1.login values(?,?,?)";

         databaseConnection.insertLogin(query,login);

    }

    @Override
    public boolean isAlive(String token,String studentId) {

        boolean result=false;
        String query="select time from student1.login where token=? and studentId=? ";

        ResultSet resultSet=databaseConnection.selectRegisterCourseRSignUpRTime(query,token,studentId);
        try {

            if (resultSet.next()) {

               LocalDateTime time=LocalDateTime.parse(resultSet.getString(1));

                result= time.plusHours(1).compareTo(LocalDateTime.now())>=0;
            }
        }catch (Exception e){
            e.getStackTrace();
        }

        return result;
    }

    @Override
    public boolean deleteLogged(String studentId) {

        String query="delete from student1.login where studentId=? ";

        return databaseConnection.delete(query,studentId);
    }

    @Override
    public boolean isLogged(String userId) {

        boolean result=false;

        String query ="select studentId from student1.login where studentId=? ";

        ResultSet resultSet=databaseConnection.select(query,userId);

        try {

            if (resultSet.next()){

                result=true;
            }
            else {

                result=false;
            }

        }catch (Exception e){
            e.getStackTrace();
        }

        return result;
    }

    @Override
    public List<Login> showLogin() {

        String query="select * from student1.login ";

        ResultSet resultSet=databaseConnection.selectColumn(query);

        List<Login> login=new ArrayList<>();

        try {

            while (resultSet.next()){

                login.add(new Login(resultSet.getString(1),resultSet.getString(2),
                       LocalDateTime.parse(resultSet.getString(3))));

            }
        }catch (Exception e){
            e.getStackTrace();
        }

        return login;
    }
}
