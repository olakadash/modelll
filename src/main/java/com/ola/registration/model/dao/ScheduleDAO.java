package com.ola.registration.model.dao;

import com.ola.registration.model.entity.Course;
import com.ola.registration.model.entity.Schedule;
import com.ola.registration.model.entity.Student;

import java.util.List;

public interface ScheduleDAO {

   List<Student>   findByCourseId(String courseId);
   List<Course>    findByStudentId(String studentId);
   boolean         deleteSchedule(String id);
   void            saveNewSchedule(Schedule schedule);
   //ToDo update method
   void            updateSchedule();
   String          scheduleIdCreator();
   boolean         isRegister(String studentId,String courseId);

}
