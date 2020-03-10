
        package com.ola.registration.model;

        import com.ola.registration.model.dao.CourseDAO;
        import com.ola.registration.model.dao.ScheduleDAO;
        import com.ola.registration.model.dao.StudentDAO;
        import com.ola.registration.model.dao.daoimpl.CourseDAOImpl;
        import com.ola.registration.model.dao.daoimpl.ScheduleDAOImpl;
        import com.ola.registration.model.dao.daoimpl.StudentDAOImpl;
        import com.ola.registration.model.entity.*;


        public class main {

        public static void main(String[] args) {

            try {


                StudentDAO studentDAOImpl = new StudentDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
                        , "root", "root@JEA");

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

                // courseDAOImpl.save(course("lk","5","5","5","4",
                      //  "5","4","42"));
              //  System.out.println(courseDAOImpl.findCourseById("as").toString());
//                //  courseDAOImpl.save(new Course("9","java","LA"));
//                courseDAOImpl.deleteCourseById("6");
//                courseDAOImpl.findCourseByName("java");
//                courseDAOImpl.findCourseByInstructor("AA");
//                courseDAOImpl.findCourseByInstructor("LA");
//                courseDAOImpl.update(new CourseBuilder().setCourseCode("").build());

                ScheduleDAO scheduleDAO=new ScheduleDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
                        , "root", "root@JEA");

                   scheduleDAO.deleteSchedule("4");

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
                             String joinYear){

         return   BuildStudentBuilderConstructor.buildStudentFromUserInput(id,firstName,lastName,email,password,joinYear);
     }

     public static Course course(String id , String courseName, String instructor, String courseCode,
                                 String capacity,String startingDate,String duration,String hours){

         return   BuildCourseBuilderConstructor.buildCourseFromUserInput(id,courseName,instructor,
                 courseCode,capacity,startingDate,duration,hours);
     }

  }
