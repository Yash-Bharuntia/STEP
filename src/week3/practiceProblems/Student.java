package week3.practiceProblems;

public class Student {
    private String name, course, studentId;
    private double grade;

    Student() {
        name = null;
        course = null;
        studentId = null;
        grade = 0;
    }

    Student(String name, String course, String studentId, double grade) {
        this.name = name;
        this.course = course;
        this.studentId = studentId;
        this.grade = grade;
    }

    void setName(String name) {
        this.name = name;
    }

    void setCourse(String course) {
        this.course = course;
    }

    void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    void setGrade(double grade) {
        this.grade = grade;
    }

    String getName() {
        return name;
    }

    String getCourse() {
        return course;
    }

    String getStudentId() {
        return studentId;
    }

    double getGrade() {
        return grade;
    }

    String calculateLetterGrade() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    void displayStudent() {
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Student ID: " + studentId);
        System.out.println("Grade: " + grade);
        System.out.println("Letter Grade: " + calculateLetterGrade());
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Aarav");
        s1.setCourse("Operating Systems");
        s1.setStudentId("OS123");
        s1.setGrade(85.5);

        Student s2 = new Student("Isha", "Data Structures", "DS456", 92.0);

        System.out.println("Getter Demo:");
        System.out.println(s1.getName() + " is enrolled in " + s1.getCourse());
        System.out.println(s2.getName() + " has a grade of " + s2.getGrade());

        System.out.println("\nStudent Details:");
        s1.displayStudent();
        s2.displayStudent();
    }
}