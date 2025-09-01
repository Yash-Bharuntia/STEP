package week3.labProblems;

class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;

    public Employee(String empName, String department, double baseSalary) {
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary;
        this.empType = "Full-Time";
        this.empId = generateEmpId();
        totalEmployees++;
    }


    public Employee(String empName, String department, double hourlyRate, int hoursWorked) {
        this.empName = empName;
        this.department = department;
        this.baseSalary = hourlyRate * hoursWorked;
        this.empType = "Part-Time";
        this.empId = generateEmpId();
        totalEmployees++;
    }

    public static String generateEmpId() {
        return String.format("EMP%03d", totalEmployees + 1);
    }

    public double calculateSalary() {
        if (empType.equals("Full-Time")) {
            double bonus = 0.10 * baseSalary;
            return baseSalary + bonus;
        } else {
            return baseSalary;
        }
    }

    public double calculateTax() {
        return switch (empType) {
            case "Full-Time" -> 0.20 * calculateSalary();
            case "Part-Time" -> 0.10 * calculateSalary();
            case "Contract" -> 0.05 * calculateSalary();
            default -> 0;
        };
    }

    public void generatePaySlip() {
        double salary = calculateSalary();
        double tax = calculateTax();
        System.out.println("----- Pay Slip -----");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Name          : " + empName);
        System.out.println("Department    : " + department);
        System.out.println("Type          : " + empType);
        System.out.println("Gross Salary  : ₹" + salary);
        System.out.println("Tax Deducted  : ₹" + tax);
        System.out.println("Net Salary    : ₹" + (salary - tax));
        System.out.println("--------------------");
    }

    public void displayEmployeeInfo() {
        System.out.println("ID        : " + empId);
        System.out.println("Name      : " + empName);
        System.out.println("Dept      : " + department);
        System.out.println("Type      : " + empType);
        System.out.println("Base Pay  : ₹" + baseSalary);
        System.out.println("--------------------");
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public static void generatePayrollReport(Employee[] employees) {
        System.out.println("=== Company Payroll Report ===");
        for (Employee e : employees) {
            e.generatePaySlip();
        }
        System.out.println("Total Employees: " + getTotalEmployees());
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Yash", "Engineering", 50000);
        employees[1] = new Employee("Aarav", "Support", 300, 40);                   // Part-Time
        employees[2] = new Employee("Diya", "Marketing", 45000);

        for (Employee e : employees) {
            e.displayEmployeeInfo();
            e.generatePaySlip();
        }
        Employee.generatePayrollReport(employees);
    }
}
