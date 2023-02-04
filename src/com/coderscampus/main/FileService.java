package com.coderscampus.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	public StudentInfo[] readStudents(String fileName) throws IOException {

		StudentService studentService = new StudentService();
		StudentInfo[] studentInfo = new StudentInfo[100];

		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			String line;

			fileReader.readLine();
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				String[] studentData = line.split(",");
				Integer studentID = Integer.parseInt(studentData[0]);
				String studentName = studentData[1];
				String course = studentData[2];
				Integer grade = Integer.parseInt(studentData[3]);

				studentInfo[i] = studentService.createStudent(studentID, studentName, course, grade);
				i++;
			}

		} finally {
			if (fileReader != null)
				fileReader.close();
		}

		return studentInfo;
	}

}
