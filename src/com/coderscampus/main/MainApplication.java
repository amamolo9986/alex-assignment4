package com.coderscampus.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		FileService fileService = new FileService();
		StudentInfo[] studentArray = fileService.readStudents("studentmasterlist.csv");

			try (BufferedWriter outputWriterCompsci = new BufferedWriter(new FileWriter("Course1.csv"));
					BufferedWriter outputWriterApmth = new BufferedWriter(new FileWriter("Course2.csv"));
					BufferedWriter outputWriterStat = new BufferedWriter(new FileWriter("Course3.csv"))) {
		
			for (int i = 0; i < studentArray.length; i++) {
			}
			Arrays.sort(studentArray, new Comparator<StudentInfo>() {

				@Override
				public int compare(StudentInfo person2, StudentInfo person1) {
					return Integer.compare(person1.getGrade(), person2.getGrade());
				}
			});
			for (StudentInfo info : studentArray) {
				System.out.println(info);
			}

			StudentInfo[] compsciArray = new StudentInfo[100];
			StudentInfo[] apmthArray = new StudentInfo[100];
			StudentInfo[] statArray = new StudentInfo[100];

			int csCtr = 0;
			int apCtr = 0;
			int statCtr = 0;

			for (StudentInfo course : studentArray) {
				if (course.getCourse().contains("COMPSCI")) {
					compsciArray[csCtr++] = course;
				}
				if (course.getCourse().contains("APMTH")) {
					apmthArray[apCtr++] = course;
				}
				if (course.getCourse().contains("STAT")) {
					statArray[statCtr++] = course;
				}
			}

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
