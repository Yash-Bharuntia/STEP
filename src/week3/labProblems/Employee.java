package Week3.LabProblems;
class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int counter = 1;

    public Employee(String name, String dept, double base, String type) {
        this.empId = "E" + String.format("%03d", counter++);
        this.empName = name;
        this.department = dept;
        this.baseSalary = base;
        this.empType = type;
    }

    public double calculateSalary(double bonus) {
        if (empType.equals("FullTime")) return baseSalary + bonus;
        return 0;
    }

    public double calculateSalary(int hours, double rate) {
        if (empType.equals("PartTime")) return hours * rate;
        return 0;
    }

    public double calculateSalary() {
        if (empType.equals("Contract")) return baseSalary;
        return 0;
    }

    public double calculateTax(double salary) {
        if (empType.equals("FullTime")) return salary * 0.2;
        if (empType.equals("PartTime")) return salary * 0.1;
        if (empType.equals("Contract")) return salary * 0.05;
        return 0;
    }

    public void generatePaySlip(double salary) {
        double tax = calculateTax(salary);
        System.out.println(empId + " " + empName + " " + department + " Type: " + empType + " Salary: " + salary + " Tax: " + tax);
    }
}

public class PayrollMain {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "IT", 50000, "FullTime");
        double s1 = e1.calculateSalary(5000);
        e1.generatePaySlip(s1);

        Employee e2 = new Employee("Bob", "HR", 0, "PartTime");
        double s2 = e2.calculateSalary(100, 200);
        e2.generatePaySlip(s2);

        Employee e3 = new Employee("Charlie", "Finance", 30000, "Contract");
        double s3 = e3.calculateSalary();
        e3.generatePaySlip(s3);
    }
}
