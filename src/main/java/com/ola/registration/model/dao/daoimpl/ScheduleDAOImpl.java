package com.ola.registration.model.dao.daoimpl;

import com.ola.registration.model.dao.ScheduleDAO;
import com.ola.registration.model.entity.Schedule;
import com.ola.registration.model.utils.DatabaseConnection;

import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {

    private DatabaseConnection databaseConnection;

    public ScheduleDAOImpl(String url , String username, String password)  {
        databaseConnection =new DatabaseConnection(url, username, password);

    }
    @Override
    public List<Schedule> findByCourseId(String courseId) {

     String query= " select * from student1.student inner join course on (course.idCourse = student.id) where course.idCourse=courseId ;";

        return null;
    }

    @Override
    public List<Schedule> findByStudentId(String studentId) {
        return null;
    }
}
}
                                                                                                                                                                              