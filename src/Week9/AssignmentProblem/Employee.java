package Week9.AssignmentProblem;

class Employee {
    int id;
    String name;
    double salary;
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee[ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}
public class Main1 {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Alice", 50000);
        Employee e2 = new Employee(102, "Bob", 60000);
        Employee e3 = new Employee(103, "Charlie", 55000);
        System.out.println(e1);
        System.out.println(e1.getClass().getName());
        System.out.println(e2);
        System.out.println(e2.getClass().getName());
        System.out.println(e3);
        System.out.println(e3.getClass().getName());
    }
}