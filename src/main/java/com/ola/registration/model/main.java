
        package com.ola.registration.model;

        import com.ola.registration.model.dao.StudentDAO;
        import com.ola.registration.model.dao.daoimpl.CourseDAOImpl;
        import com.ola.registration.model.dao.daoimpl.StudentDAOImpl;
        import com.ola.registration.model.entity.CourseBuilder;
        import com.ola.registration.model.entity.NewStudentBuilder;
        import com.ola.registration.model.entity.Student;
        import com.ola.registration.model.entity.StudentBuilder;


 public class main {

        public static void main(String[] args) {

            try {


                StudentDAO studentDAOImpl = new StudentDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
                        , "root", "root@JEA");

//                System.out.println(studentDAOImpl.findByEmail("ola@gmail.com"));
//
//                System.out.println(studentDAOImpl.findById("9"));

                studentDAOImpl.save( student("pl","sd","sd","ds","ds","s"));
                System.out.println(studentDAOImpl.deleteStudentById("5"));

                // studentDAOImpl.update(new Student("9","kadash3","555","sam2ar@gmail.com","samar",
                //  "1/2/225"));

                // calc(1,6,8);
//
//                CourseDAOImpl courseDAOImpl = new CourseDAOImpl("jdbc:mysql://localhost:3306/student1?useSSL=false"
//                        , "root", "root@JEA");
//
//                courseDAOImpl.findCourseById("6");
//                //courseDAOImpl.save(new Course("7","java","AA"));
//                //  courseDAOImpl.save(new Course("9","java","LA"));
//                courseDAOImpl.deleteCourseById("6");
//                courseDAOImpl.findCourseByName("java");
//                courseDAOImpl.findCourseByInstructor("AA");
//                courseDAOImpl.findCourseByInstructor("LA");
//                courseDAOImpl.update(new CourseBuilder().setCourseCode("").build());


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

         return   NewStudentBuilder.creatStudent(id,firstName,lastName,email,password,joinYear);
     }

  }
