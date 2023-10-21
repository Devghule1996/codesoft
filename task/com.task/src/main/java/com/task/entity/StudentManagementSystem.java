package com.task.entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManagementSystem {
    private List<student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Method to add a student to the collection
    public void addStudent(student student) {
        students.add(student);
    }

    // Method to remove a student by roll number
    public void removeStudent(int rollNumber) {
        Iterator<student> iterator = students.iterator();
        while (iterator.hasNext()) {
            student student = iterator.next();
            if (student.getRollNumber() == rollNumber) {
                iterator.remove();
                System.out.println("Student with Roll Number " + rollNumber + " removed.");
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Method to search for a student by roll number
    public student searchStudent(int rollNumber) {
        for (student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    // Method to display all students
    public List<student> displayAllStudents() {
        for (student student : students) {
            System.out.println(student);
        }
		return students;
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        student student1 = new student("John Doe", 101, 'A');
        student student2 = new student("Jane Smith", 102, 'B');

        sms.addStudent(student1);
        sms.addStudent(student2);

        System.out.println("All Students:");
        sms.displayAllStudents();

        int searchRollNumber = 101;
        student foundStudent = sms.searchStudent(searchRollNumber);
        if (foundStudent != null) {
            System.out.println("\nStudent found by Roll Number " + searchRollNumber + ":");
            System.out.println(foundStudent);
        } else {
            System.out.println("\nStudent with Roll Number " + searchRollNumber + " not found.");
        }

        int removeRollNumber = 102;
        sms.removeStudent(removeRollNumber);
        System.out.println("\nUpdated list of students:");
        sms.displayAllStudents();
    }
}
