package com.coderscampus.main;

public class StudentService {
	public StudentInfo createStudent(int studentID, String studentName, String course, int grade) {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentID(studentID);
		studentInfo.setStudentName(studentName);
		studentInfo.setCourse(course);
		studentInfo.setGrade(grade);
		return studentInfo;
	}
}
