
package com.ola.registration.model.utils;

import com.ola.registration.model.entity.Course;
import com.ola.registration.model.entity.Login;
import com.ola.registration.model.entity.Schedule;
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

           this.connection = new JeaQueue(20);
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
                 preparedStatement.setString(7,student.getUserType());

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
                preparedStatement.setString(7,student.getUserType());

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
                 preparedStatement.setString(5, String.valueOf(course.getCapacity()));
                 preparedStatement.setString  (6 , String.valueOf(course.getStartingDate()));
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
            preparedStatement.setString(4, String.valueOf(course.getCapacity()));
            preparedStatement.setString(5, String.valueOf(course.getStartingDate()));
            preparedStatement.setString(6,course.getDuration());
            preparedStatement.setString(7,course.getHours());
            preparedStatement.setString(8,course.getCourseId());

            preparedStatement.executeUpdate();


        } catch (Exception e) {
             e.getMessage();}
   }


     public void insertSchedule(String query, Schedule schedule) {

         try {
             preparedStatement = getConnection().getConnection().prepareStatement(query);

               preparedStatement.setString(1,schedule.getScheduleId());
               preparedStatement.setString(2,schedule.getStudentId());
               preparedStatement.setString(3,schedule.getCourseId());

             preparedStatement.executeUpdate();

         }catch (Exception e){
            e.getStackTrace();
         }
     }

     public ResultSet selectColumn(String query) {

       try {

           preparedStatement = getConnection().getConnection().prepareStatement(query);
           resultSet = preparedStatement.executeQuery();

       }catch (Exception e){
           e.getStackTrace();
       }

       return resultSet;
     }

     public ResultSet selectRegisterCourseRSignUpRTime(String query,String studentId, String courseIdRpassword) {

         try {


             preparedStatement = getConnection().getConnection().prepareStatement(query);
             preparedStatement.setString(1,studentId);
             preparedStatement.setString(2,courseIdRpassword);
             resultSet=preparedStatement.executeQuery();

         }catch (Exception e){
             e.getStackTrace();
         }

         return resultSet;
     }


     public void insertLogin(String query, Login login) {

       try {
           preparedStatement=getConnection().getConnection().prepareStatement(query);
           preparedStatement.setString(1,login.getToken());
           preparedStatement.setString(2,login.getStudentId());
           preparedStatement.setString(3,String.valueOf(login.getTime()));

           preparedStatement.executeUpdate();

       }catch (Exception e){
           e.getStackTrace();
       }
     }


     public boolean deleteSchedule(String query, String studentId, String courseId) {

         boolean resultDelete=false;

         try {

             preparedStatement= getConnection().getConnection().prepareStatement(query);

             preparedStatement.setString(1, studentId);
             preparedStatement.setString(2,courseId);
             preparedStatement.executeUpdate();

             resultDelete=true;

             //release();

         } catch (Exception e) {
             e.getMessage();}

         return resultDelete;
     }
 }

