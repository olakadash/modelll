package com.ola.registration.model.entity;

public class Schedule {

   private String  studentId;
   private String  courseId;
   private String  scheduleId;

   public Schedule(String studentId, String courseId,String scheduleId ) {
      this.studentId = studentId;
      this.courseId = courseId;
      this.scheduleId=scheduleId;
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
              "studentId='" + studentId + '\'' +
              ", courseId='" + courseId + '\'' +
              ", scheduleId='" + scheduleId + '\'' +
              '}';
   }
}
