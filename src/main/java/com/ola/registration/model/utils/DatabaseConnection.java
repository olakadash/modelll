
package com.ola.registration.model.utils;

import com.ola.registration.model.entity.Course;
import com.ola.registration.model.entity.Student;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



 public class DatabaseConnection  {

        private PreparedStatement preparedStatement;
        private ResultSet resultSet;
        private JeaQueue<ConnectionWrapper> connection;
        private ConnectionWrapper connectionWrapper;
        private String url;
        private String userName;
        private String password;


   public DatabaseConnection(String url, String userName, String password) {

           this.connection = new JeaQueue(10);
           this.url = url;
           this.userName = userName;
           this.password = password;

        }


   public ConnectionWrapper getConnection() {

       try {

          if (this.connection.isempty()) {

             return new ConnectionWrapper(DriverManager.getConnection(url, userName, password));

          } else {

             connectionWrapper = this.connection.deQueue();

             if (connectionWrapper.isAlive()) {
                     return connectionWrapper; }
             else {
                     connectionWrapper.getConnection().close();
                     return getConnection(); }
          }
          } catch (Exception e) {
              System.out.println(e); }

           return null;
   }


   public void release() {

           this.connection.enQueue(connectionWrapper);

   }


    public ResultSet select(String query,String idREmailRName) {

        try {

          preparedStatement = getConnection().getConnection().prepareStatement(query);

           preparedStatement.setString(1,idREmailRName);
           resultSet=preparedStatement.executeQuery();

        // release();

            } catch (Exception e) {
                  e.getMessage(); }

        return resultSet;
   }


   public void insertStudent(String query, Student student){

           try {

             preparedStatement = getConnection().getConnection().prepareStatement(query);

                 preparedStatement.setString(1,student.getId());
                 preparedStatement.setString(2,student.getFirstName());
                 preparedStatement.setString(3,student.getLastName());
                 preparedStatement.setString(4,student.getEmail());
                 preparedStatement.setString(5,student.getPassword());
                 preparedStatement.setString(6,student.getJoinYear());

             preparedStatement.executeUpdate();
        //release();

           } catch (Exception e) {
                e.getMessage(); }
   }


    public void updateStudent(String query, Student student){

           try {

             preparedStatement = getConnection().getConnection().prepareStatement(query);

                preparedStatement.setString(1,student.getFirstName());
                preparedStatement.setString(2,student.getLastName());
                preparedStatement.setString(3,student.getEmail());
                preparedStatement.setString(4,student.getPassword());
                preparedStatement.setString(5,student.getJoinYear());
                preparedStatement.setString(6,student.getId());

              preparedStatement.executeUpdate();


           } catch (Exception e) {
                 e.getMessage();}

   }


   public boolean delete(String query, String id){

        boolean resultDelete=false;

           try {

                preparedStatement= getConnection().getConnection().prepareStatement(query);

                   preparedStatement.setString(1, id);
                   preparedStatement.executeUpdate();

        resultDelete=true;

        //release();

           } catch (Exception e) {
                   e.getMessage();}

        return resultDelete;
   }


   public void insertCourse(String query, Course course){

           try {

              preparedStatement = getConnection().getConnection().prepareStatement(query);

                 preparedStatement.setString(1,course.getCourseId());
                 preparedStatement.setString(2,course.getCourseName());
                 preparedStatement.setString(3,course.getInstructor());
                 preparedStatement.setString(4,course.getCourseCode());
                 preparedStatement.setString(5,course.getCapacity());
                 preparedStatement.setString(6,course.getStartingDate());
                 preparedStatement.setString(7,course.getDuration());
                 preparedStatement.setString(8,course.getHours());

              preparedStatement.executeUpdate();
              //release();

           } catch (Exception e) {
                e.getMessage(); }
   }


   public void updateCourse(String query, Course course){

        try {

            preparedStatement = getConnection().getConnection().prepareStatement(query);


            preparedStatement.setString(1,course.getCourseName());
            preparedStatement.setString(2,course.getInstructor());
            preparedStatement.setString(3,course.getCourseCode());
            preparedStatement.setString(4,course.getCapacity());
            preparedStatement.setString(5,course.getStartingDate());
            preparedStatement.setString(6,course.getDuration());
            preparedStatement.setString(7,course.getHours());
            preparedStatement.setString(8,course.getCourseId());

            preparedStatement.executeUpdate();


        } catch (Exception e) {
             e.getMessage();}
   }


}

