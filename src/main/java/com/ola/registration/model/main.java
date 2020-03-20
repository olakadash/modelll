
        package com.ola.registration.model;

        import com.ola.registration.model.dao.CourseDAO;
        import com.ola.registration.model.dao.LoginDAO;
        import com.ola.registration.model.dao.ScheduleDAO;
        import com.ola.registration.model.dao.StudentDAO;
        import com.ola.registration.model.dao.daoimpl.CourseDAOImpl;
        import com.ola.registration.model.dao.daoimpl.LoginDAOImpl;
        import com.ola.registration.model.dao.daoimpl.ScheduleDAOImpl;
        import com.ola.registration.model.dao.daoimpl.StudentDAOImpl;
        import com.ola.registration.model.entity.*;

        import java.time.LocalDateTime;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;


        public class main {

        public static void main(String[] args) {

            try {


                StudentDAO studentDAOImpl = new StudentDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
                        , "root", "root@JEA");

                System.out.println(studentDAOImpl.findByEmail("ali@").toString());

               // System.out.println(studentDAOImpl.isSignUpChecker("1","123"));
//                System.out.println(studentDAOImpl.findByEmail("ola@gmail.com"));
//
              // System.out.println(studentDAOImpl.findById("9").toString());

               // studentDAOImpl.save( student("pl","sd","sd","ds","ds","s"));
               // System.out.println(studentDAOImpl.deleteStudentById("5"));

                // studentDAOImpl.update(new Student("9","kadash3","555","sam2ar@gmail.com","samar",
                //  "1/2/225"));

                // calc(1,6,8);
//
                CourseDAO courseDAOImpl = new CourseDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
                       , "root", "root@JEA");
//
                //System.out.println(courseDAOImpl.findCourseByName("q"));
               /* List<Course> d =courseDAOImpl.findCourseByInstructor("44");
                for (int i=0;i<d.size();i++){

                    System.out.println(d.get(i).toString());

                }*/

                // courseDAOImpl.save(course("lk","5","5","5","4",
                      //  "5","4","42"));
               // System.out.println(courseDAOImpl.findCourseById("2").toString());
                //System.out.println(new Date());
//                //  courseDAOImpl.save(new Course("9","java","LA"));

                //System.out.println(courseDAOImpl.deleteCourseById("2"));
//                courseDAOImpl.findCourseByName("java");
//                courseDAOImpl.findCourseByInstructor("AA");
//                courseDAOImpl.findCourseByInstructor("LA");
//                courseDAOImpl.update(new CourseBuilder().setCourseCode("").build());

                ScheduleDAO scheduleDAO=new ScheduleDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
                        , "root", "root@JEA");
                 scheduleDAO.deleteSchedule("1","2");
                  // scheduleDAO.deleteSchedule("4");
               // scheduleDAO.saveNewSchedule(new Schedule("3","1","2"));

               // System.out.println(scheduleDAO.isRegister("1","1"));
               // scheduleDAO.findByCourseId("2");

                LoginDAO loginDAO=new LoginDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
                        , "root", "root@JEA");

                //System.out.println(loginDAO.isLogged("6"));
               // loginDAO.save(new Login("2","1236", LocalDateTime.now()));

               // System.out.println( loginDAO.isAlive("1236","1"));

               // System.out.println(loginDAO.deleteLogged("2"));
               List<Login> list= loginDAO.showLogin();

               for (Login login: list){

                   System.out.println(login.toString());
               }

            }catch (Exception e){
                e.getStackTrace(); }


        }


//     public static void calc(int... numbers){
//
//        int sum=0;
//        for (int i:numbers){
//        sum=sum+i;
//        System.out.println(sum); }
//
//
//     }

     public static Student student(String id , String firstName, String lastName, String email, String password,
                             String joinYear,String userType){

         return   BuildStudentBuilderConstructor.buildStudentFromUserInput(id,firstName,lastName,email,password,joinYear,userType);
     }
//if admin enter new course
     public static Course course(String id , String courseName, String instructor, String courseCode,
                                 Double capacity, Date startingDate, String duration, String hours){

         return   BuildCourseBuilderConstructor.buildCourseFromUserInput(id,courseName,instructor,
                 courseCode,capacity, (java.sql.Date) startingDate,duration,hours);
     }

  }
