package Week3.AssignmentProblem;

import java.util.*;

class Employee {
    private String empId, empName, department, designation, joinDate;
    private double baseSalary;
    private boolean[] attendance;
    private static int counter = 1;

    public Employee(String name, String dept, String desg, double salary, String joinDate) {
        empId = "E" + String.format("%03d", counter++);
        empName = name; department = dept; designation = desg;
        baseSalary = salary; this.joinDate = joinDate;
        attendance = new boolean[30];
    }

    public void markAttendance(int day, boolean present) { if (day > 0 && day <= 30) attendance[day-1] = present; }
    public double calculateSalary() { int present = 0; for (boolean d : attendance) if (d) present++; return (baseSalary/30)*present; }
    public double calculateBonus() { return baseSalary * 0.1; }
    public void generatePaySlip() { double sal = calculateSalary(); double bonus = calculateBonus(); System.out.println(empId+" | "+empName+" | Salary: "+sal+" | Bonus: "+bonus+" | Total: "+(sal+bonus)); }
}

public class Assignment6Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice","IT","Manager",60000,"2024-01-01");
        Employee e2 = new Employee("Bob","HR","Executive",40000,"2024-05-01");
        for(int i=1;i<=20;i++) e1.markAttendance(i,true);
        for(int i=1;i<=15;i++) e2.markAttendance(i,true);
        e1.generatePaySlip();
        e2.generatePaySlip();
    }
}
