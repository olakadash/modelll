package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.StudentDAO;
import com.ola.registration.model.entity.BuildStudentBuilderConstructor;
import com.ola.registration.model.utils.DatabaseConnection;
import com.ola.registration.model.entity.Student;
import java.sql.ResultSet;


public class StudentDAOImpl implements StudentDAO  {

     private DatabaseConnection databaseConnection;

    public StudentDAOImpl(String url , String username, String password)  {
        databaseConnection =new DatabaseConnection(url, username, password);

    }

    public Student  findById(String id)  {

        Student student=null;
         try{

        String query = " select * from student1.student where id=?";

        ResultSet resultSet =  databaseConnection.select(query,id);

        if (resultSet.next()){

          student= BuildStudentBuilderConstructor.buildStudentFromResultSET(resultSet);


        }
         }catch (Exception e){
             System.out.println(e);
           }

         return student;
    }

    public String findByEmail(String email)  {
        String result= " ";

        try {
            String query = " select * from student1.student where email=?";

            ResultSet resultSet = databaseConnection.select(query, email);

            while (resultSet.next()) {

                result =  resultSet.getString(4) ;

            }

        }catch (Exception e){
            System.out.println(e);
        }

        return result;
    }

    public void save(Student student) {

        String query = " insert into student1.student  values(?,?,?,?,?,?)";
        databaseConnection.insertStudent(query,student);

    }

    public void update(Student student)  {

        //ToDO handel update query
        String query = " update  student1.student set firstName=? ,lastName=? , email=? ,password=?,joinYear=? where id=? ;";

        databaseConnection.updateStudent(query,student);

    }


    public boolean deleteStudentById(String ID) {

        String query = " delete from student1.student where id=? ";

     boolean result= databaseConnection.delete(query , ID);

     return result;

    }



}
