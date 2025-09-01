package week3.assignmentProblems;

import java.util.*;
class Employee{
    String id;
    String name;
    String type;
    String department;
    double baseSalary;
    String joinDate;
    boolean[] attendance;
    public Employee(String id,String name,String type,String department,double baseSalary,String joinDate){
        this.id=id;
        this.name=name;
        this.type=type;
        this.department=department;
        this.baseSalary=baseSalary;
        this.joinDate=joinDate;
        this.attendance=new boolean[30];
    }
    public void mark(int day,boolean present){
        if(day>=1 && day<=30) attendance[day-1]=present;
    }
    public int presents(){
        int c=0;
        for(boolean b:attendance) if(b) c++;
        return c;
    }
    public double computeSalary(){
        double salary=baseSalary;
        if(type.equals("Part-time")) salary=baseSalary*0.6;
        if(type.equals("Contract")) salary=baseSalary*0.8;
        double daily=salary/30.0;
        salary=daily*presents();
        return salary;
    }
}
class Company{
    String id;
    String name;
    Employee payrollEmployee;
    Employee[] employees;
    double budget;
    static int totalEmployees=0;
    static String companyName="Simple Corp";
    static double bonusRate=0.1;
    static int leaveLimit=2;
    int size=0;
    public Company(String id,String name,double budget){
        this.id=id;
        this.name=name;
        this.budget=budget;
        this.employees=new Employee[100];
    }
    public void addEmployee(Employee e){
        employees[size++]=e;
        totalEmployees++;
    }
    public double performanceBonus(Employee e){
        int p=e.presents();
        if(p>=26) return e.baseSalary*bonusRate;
        return 0;
    }
    public void processPayroll(){
        double total=0;
        for(int i=0;i<size;i++){
            Employee e=employees[i];
            double sal=e.computeSalary()+performanceBonus(e);
            total+=sal;
            System.out.println(e.id+" "+e.name+" "+sal);
        }
        System.out.println("Total payroll: "+total);
    }
    public static void setCompanyName(String n){ companyName=n; }
    public static void setBonusRate(double r){ bonusRate=r; }
    public static void setLeaveLimit(int l){ leaveLimit=l; }
}
public class Assignment6{
    public static void main(String[] args){
        Company c=new Company("C1","NeoTech",1000000);
        Employee e1=new Employee("E1","Karan","Full-time","IT",60000,"2024-01-01");
        Employee e2=new Employee("E2","Leena","Part-time","HR",40000,"2023-02-01");
        Employee e3=new Employee("E3","Mohan","Contract","Ops",50000,"2022-03-01");
        c.addEmployee(e1);
        c.addEmployee(e2);
        c.addEmployee(e3);
        for(int d=1;d<=28;d++){ e1.mark(d,true); }
        for(int d=1;d<=20;d++){ e2.mark(d,true); }
        for(int d=1;d<=25;d++){ e3.mark(d,true); }
        c.processPayroll();
        Company.setBonusRate(0.2);
        c.processPayroll();
    }
}