package com.coderscampus.main;

import java.io.IOException;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		FileService fileService = new FileService();
		StudentInfo[] studentArray = fileService.readStudents("studentmasterlist.csv");
		StudentService.studentWriter(studentArray);
	}

}

