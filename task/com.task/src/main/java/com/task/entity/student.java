package com.task.entity;

public class student {
	
	    // Attributes
	    private String name;
	    private int rollNumber;
	    private char grade;
	    
	    // Constructor
	    public student(String name, int rollNumber, char grade) {
	        this.name = name;
	        this.rollNumber = rollNumber;
	        this.grade = grade;
	    }
	    
	    // Getters and Setters
	    public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public int getRollNumber() {
	        return rollNumber;
	    }
	    
	    public void setRollNumber(int rollNumber) {
	        this.rollNumber = rollNumber;
	    }
	    
	    public char getGrade() {
	        return grade;
	    }
	    
	    public void setGrade(char grade) {
	        this.grade = grade;
	    }
	    
	    // toString method to display student information
	    @Override
	    public String toString() {
	        return "Student Name: " + name + "\n" +
	               "Roll Number: " + rollNumber + "\n" +
	               "Grade: " + grade;
	    }
	    
	    public static void main(String[] args) {
	        // Example usage of the Student class
	        student student1 = new student("John Doe", 101, 'A');
	        student student2 = new student("Jane Smith", 102, 'B');

	        System.out.println("Student 1:");
	        System.out.println(student1);
	        
	        System.out.println("\nStudent 2:");
	        System.out.println(student2);
	    }
	}



