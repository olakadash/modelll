package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Schedule;
import com.ola.registration.model.entity.Student;

import java.util.List;

public interface ScheduleDAO {

   List<Schedule> findByCourseId(String courseId);
   List<Schedule> findByStudentId(String studentId);
  // boolean deleteSchedule(String id);
 //  void    saveNewSchedule();
   // void  updateSchedule();


}
