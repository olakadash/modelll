
package com.ola.registration.model.utils;

        import com.ola.registration.model.entity.Course;
        import com.ola.registration.model.entity.Student;

        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;

        public class DatabaseConnection {
        private PreparedStatement preparedStatement ;
        private ResultSet resultSet;

        private JeaQueue <ConnectionWrapper> connection;
        private ConnectionWrapper connectionWrapper;
        private String url;
        private String userName;
        private String password;

        public DatabaseConnection(String url,String userName,String password){
        this.connection=new JeaQueue(10);
        this.url = url;
        this.userName = userName;
        this.password = password;
        }

        public ConnectionWrapper getConnection () throws SQLException {
        if(this.connection.isempty()){
        return new ConnectionWrapper(DriverManager.getConnection(url,userName,password));

        }else {
        connectionWrapper=this.connection.deQueue();
        if(connectionWrapper.isAlive()){
        return connectionWrapper;
        } else{
        connectionWrapper.getConnection().close();
        return getConnection();
        }
        }
        }

        public void release() throws SQLException {

        this.connection.enQueue(connectionWrapper);

        }


        public ResultSet select(String query,String idREmail) {

        try {
        preparedStatement = getConnection().getConnection().prepareStatement(query);

        preparedStatement.setString(1,idREmail);
        resultSet=preparedStatement.executeQuery();

        // release();

        } catch (Exception e) {
        e.getMessage();
        }

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


        public void delete(String query, String id){

        String resultDelete="cant delete ";

        try {
        preparedStatement= getConnection().getConnection().prepareStatement(query);

        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();
        resultDelete=" ID ="+id+" Successfully deleted ";

        //release();

        } catch (Exception e) {
        e.getMessage();}

        System.out.println(resultDelete);
        }

        public void insertCourse(String query, Course course){
        try {
        preparedStatement = getConnection().getConnection().prepareStatement(query);

        preparedStatement.setString(1,course.getId());
        preparedStatement.setString(2,course.getCourseName());
        preparedStatement.setString(3,course.getInstructor());

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
        preparedStatement.setString(3,course.getId());


        preparedStatement.executeUpdate();


        } catch (Exception e) {
        e.getMessage();}
        }

        }

