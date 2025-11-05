package Week3.AssignmentProblem;

import java.util.*;

class Student {
    private String studentId, studentName;
    private double[] marks;
    private double gpa;
    private static int counter = 1;

    public Student(String name, int subjects) {
        studentId = "S" + String.format("%03d", counter++);
        studentName = name;
        marks = new double[subjects];
    }

    public void addMarks(int idx, double mark) { if (idx >= 0 && idx < marks.length) marks[idx] = mark; }
    public void calculateGPA() { double sum = 0; for (double m : marks) sum += m; double avg = sum / marks.length; if (avg >= 90) gpa = 10; else if (avg >= 80) gpa = 9; else if (avg >= 70) gpa = 8; else if (avg >= 60) gpa = 7; else if (avg >= 50) gpa = 6; else gpa = 5; }
    public double getGpa() { return gpa; }
    public String toString() { return studentId + " " + studentName + " GPA " + gpa; }
}

public class Assignment4Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice",5);
        Student s2 = new Student("Bob",5);
        Student s3 = new Student("Charlie",5);
        for(int i=0;i<5;i++){ s1.addMarks(i,95); s2.addMarks(i,75); s3.addMarks(i,55); }
        s1.calculateGPA(); s2.calculateGPA(); s3.calculateGPA();
        System.out.println(s1); System.out.println(s2); System.out.println(s3);
    }
}
