package Week9.PraticeProblem;

// File: Employee.java
import java.util.Objects;

public class Employee {
    private String empCode;
    private String name;

    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return empCode.equals(e.empCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empCode);
    }

    @Override
    public String toString() {
        return "Employee Code: " + empCode + ", Name: " + name;
    }
}
// File: EmployeeAuth.java
import java.util.*;

public class EmployeeAuth {
    public static void main(String[] args) {
        Employee e1 = new Employee("BL001", "Ritika");
        Employee e2 = new Employee("BL001", "Ritika S.");

        System.out.println("== Comparison: " + (e1 == e2));
        System.out.println("equals() Comparison: " + e1.equals(e2));

        Set<Employee> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        System.out.println("HashSet Size: " + set.size());
        System.out.println(set);
    }
}
