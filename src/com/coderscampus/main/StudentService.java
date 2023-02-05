package com.coderscampus.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class StudentService {
	public StudentInfo createStudent(int studentID, String studentName, String course, int grade) {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentID(studentID);
		studentInfo.setStudentName(studentName);
		studentInfo.setCourse(course);
		studentInfo.setGrade(grade);
		return studentInfo;
	}
	public static void studentWriter(StudentInfo[] studentArray) throws IOException {
		try (BufferedWriter outputWriterCompsci = new BufferedWriter(new FileWriter("Course1.csv"));
				BufferedWriter outputWriterApmth = new BufferedWriter(new FileWriter("Course2.csv"));
				BufferedWriter outputWriterStat = new BufferedWriter(new FileWriter("Course3.csv"))) {

			Arrays.sort(studentArray, new Comparator<StudentInfo>() {

				@Override
				public int compare(StudentInfo person2, StudentInfo person1) {
					return Integer.compare(person1.getGrade(), person2.getGrade());
				}
			});

			StudentInfo[] compsciArray = new StudentInfo[34];
			StudentInfo[] apmthArray = new StudentInfo[33];
			StudentInfo[] statArray = new StudentInfo[33];
		
			int csCtr = 0;
			int apCtr = 0;
			int statCtr = 0;

			for (StudentInfo student : studentArray) {
				if (student.getCourse().contains("COMPSCI")) {
					compsciArray[csCtr++] = student;
				}
				if (student.getCourse().contains("APMTH")) {
					apmthArray[apCtr++] = student;
				}
				if (student.getCourse().contains("STAT")) {
					statArray[statCtr++] = student;
				}
			}
			// this all can be refactored with removing lines 35-37 and changing my for loop ^^^^

			for (int i = 0; i < compsciArray.length; i++) {
				outputWriterCompsci.write(compsciArray[i] + "");
				outputWriterCompsci.newLine();
			}
			outputWriterCompsci.flush();
			outputWriterCompsci.close();

			for (int i = 0; i < apmthArray.length; i++) {
				outputWriterApmth.write(apmthArray[i] + "");
				outputWriterApmth.newLine();
			}
			outputWriterApmth.flush();
			outputWriterApmth.close();

			for (int i = 0; i < statArray.length; i++) {
				outputWriterStat.write(statArray[i] + "");
				outputWriterStat.newLine();
			}
			outputWriterStat.flush();
			outputWriterStat.close();
		}
	}
}
