
        package com.ola.registration.model;

        import com.ola.registration.model.dao.daoimpl.CourseDAOImpl;
        import com.ola.registration.model.dao.daoimpl.StudentDAOImpl;
        import com.ola.registration.model.entity.CourseBuilder;
        import com.ola.registration.model.entity.Student;
        import com.ola.registration.model.entity.StudentBuilder;

        import java.sql.SQLException;

        public class main {

        public static void main(String[] args) throws SQLException {

        StudentDAOImpl studentDAOImpl=new StudentDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
        ,"root","root@JEA");
        studentDAOImpl.findByEmail("ola@gmail.com");

        studentDAOImpl.findById("9");

        studentDAOImpl.save(new StudentBuilder().setEmailBuilder("").build());
        studentDAOImpl.delete("5");

       // studentDAOImpl.update(new Student("9","kadash3","555","sam2ar@gmail.com","samar",
      //  "1/2/225"));

        // calc(1,6,8);

        CourseDAOImpl courseDAOImpl =new CourseDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
        ,"root","root@JEA");

        courseDAOImpl.findCourseById("6");
        //courseDAOImpl.save(new Course("7","java","AA"));
        //  courseDAOImpl.save(new Course("9","java","LA"));
        courseDAOImpl.deleteCourseById("6");
        courseDAOImpl.findCourseByName("java");
        courseDAOImpl.findCourseByInstructor("AA");
        courseDAOImpl.findCourseByInstructor("LA");
        courseDAOImpl.update(new CourseBuilder().setCourseCode("").build());


        }


        public static void calc(int... numbers){
        int sum=0;
        for (int i:numbers){
        sum=sum+i;
        System.out.println(sum);
        }

        }
        }
