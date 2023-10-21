package com.task.entity;

	import java.io.*;
	import java.util.ArrayList;
	import java.util.List;

	public class StudentFileHandler {
	    // Method to write student data to a text file
	    public static void writeStudentsToFile(List<student> students, String filename) {
	        try (FileWriter writer = new FileWriter(filename);
	             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

	            for (student student : students) {
	                bufferedWriter.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
	                bufferedWriter.newLine();
	            }
	            System.out.println("Student data has been written to " + filename);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    // Method to read student data from a text file
	    public static List<student> readStudentsFromFile(String filename) {
	        List<student> students = new ArrayList<>();
	        try (FileReader reader = new FileReader(filename);
	             BufferedReader bufferedReader = new BufferedReader(reader)) {

	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    String name = parts[0];
	                    int rollNumber = Integer.parseInt(parts[1]);
	                    char grade = parts[2].charAt(0);
	                    students.add(new student(name, rollNumber, grade));
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return students;
	    }

	    public static void main(String[] args) {
	        // Example usage:
	        List<student> students = new ArrayList<>();
	        students.add(new student("John Doe", 101, 'A'));
	        students.add(new student("Jane Smith", 102, 'B'));

	        // Write students to a file
	        writeStudentsToFile(students, "student_data.txt");

	        // Read students from the file
	        List<student> loadedStudents = readStudentsFromFile("student_data.txt");
	        System.out.println("Loaded Students:");
	        for (student student : loadedStudents) {
	            System.out.println(student);
	        }
	    }
	}



