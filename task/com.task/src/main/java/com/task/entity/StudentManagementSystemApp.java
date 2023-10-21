package com.task.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystemApp {
    private static StudentManagementSystem sms;

    public static void main(String[] args) {
        sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add a New Student");
            System.out.println("2. Edit Student Information");
            System.out.println("3. Search for a Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    editStudent(scanner);
                    break;
                case 3:
                    searchStudent(scanner);
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the Student Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter student grade: ");
        char grade = scanner.next().charAt(0);

        student student = new student(name, rollNumber, grade);
        sms.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void editStudent(Scanner scanner) {
        System.out.print("Enter student roll number to edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);

            System.out.print("Enter new name (or press Enter to keep the current name): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                student.setName(newName);
            }

            System.out.print("Enter new grade (or press Enter to keep the current grade): ");
            String newGradeStr = scanner.nextLine();
            if (!newGradeStr.isEmpty()) {
                char newGrade = newGradeStr.charAt(0);
                student.setGrade(newGrade);
            }

            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student roll number to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    private static void displayAllStudents() {
        List<student> students = sms.displayAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All Students:");
            for (student student : students) {
                System.out.println(student);
            }
        }
    }
}

	


