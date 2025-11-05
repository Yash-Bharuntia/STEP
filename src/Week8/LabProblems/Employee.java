package Week8.LabProblems;

abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();
}

interface Payable {
    void generatePaySlip();
}

class Manager extends Employee implements Payable {
    private String department;

    public Manager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    public double calculateBonus() {
        double bonus = salary * 0.10;
        System.out.println("Bonus for Manager: " + bonus);
        return bonus;
    }

    @Override
    public void generatePaySlip() {
        System.out.println("Pay Slip -> Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Manager mgr = new Manager("Raghav", 80000, "IT");
        mgr.generatePaySlip();
        mgr.calculateBonus();
    }
}
