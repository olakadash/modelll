package com.ola.registration.model.entity;

public class Schedule {

   private String  scheduleId;
   private String  studentId;
   private String  courseId;


   public Schedule(String scheduleId,String studentId, String courseId ) {

      this.scheduleId=scheduleId;
      this.studentId = studentId;
      this.courseId = courseId;

   }

   public void setStudentId(String studentId) {
      this.studentId = studentId;
   }

   public void setCourseId(String courseId) {
      this.courseId = courseId;
   }

   public String getStudentId() {
      return studentId;
   }

   public String getCourseId() {
      return courseId;
   }

   public void setScheduleId(String scheduleId) {
      this.scheduleId = scheduleId;
   }

   public String getScheduleId() {
      return scheduleId;
   }

   @Override
   public String toString() {
      return "Schedule{" +
              "scheduleId='" + scheduleId + '\'' +
              ", studentId='" + studentId + '\'' +
              ", courseId='" + courseId + '\'' +
              '}';
   }
}
