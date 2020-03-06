package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.StudentDAO;
import com.ola.registration.model.utils.DatabaseConnection;
import com.ola.registration.model.entity.Student;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO  {

    private DatabaseConnection databaseConnection;

    public StudentDAOImpl(String url , String username, String password)  {
        databaseConnection =new DatabaseConnection(url, username, password);

    }

    public void findById(String id)  {
         try{

        String query = " select * from student1.student "
                + "where id=?";

        ResultSet resultSet =  databaseConnection.select(query,id);

        while (resultSet.next()){

                System.out.println("idFound:- "+resultSet.getString(1)+
                        "\n info :"  +
                        "\nfirstName:- "+resultSet.getString(2)+
                        "\nlastName:- "+ resultSet.getString(3)
                        +"\nEmail:- "+ resultSet.getString(4)
                        +"\njoinYear:- " + resultSet.getString(6)+"\n");

        }
    }catch (SQLException e){
        System.out.println(e);
    }
    }

    public void findByEmail(String email)  {
        try {
            String query = " select * from student1.student "
                    + "where email=?";

            ResultSet resultSet = databaseConnection.select(query, email);

            while (resultSet.next()) {
                System.out.println("\n emailFound " + resultSet.getString(4) + "\n Other Info:- " +
                        "\n ID:- " + resultSet.getString(1) +
                        "\n firstName:- " + resultSet.getString(2) +
                        "\n lastName:- " + resultSet.getString(3)
                        + "\n joinYear:- " + resultSet.getString(6) + "\n");
            }

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void save(Student student) {

        String query = " insert into student1.student " +" values(?,?,?,?,?,?)";
        databaseConnection.insertStudent(query,student);

    }

    public void update(Student student)  {
        String query = " update  student1.student " +" set firstName=? ,lastName=? , email=? ,password=?,joinYear=? " +
                                      " where id=? ;";

        databaseConnection.updateStudent(query,student);

    }


    public void delete(String ID) {

        String query = " delete from student1.student where id=?";

         databaseConnection.delete(query , ID);

    }


}
