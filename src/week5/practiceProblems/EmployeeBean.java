import java.io.Serializable;
import java.util.*;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {}

    public EmployeeBean(String employeeId, String firstName, String lastName, double salary,
                        String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        setSalary(salary);
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary >= 0) this.salary = salary;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public String getFullName() { return firstName + " " + lastName; }

    public int getYearsOfService() {
        Calendar start = Calendar.getInstance();
        start.setTime(hireDate);
        return Calendar.getInstance().get(Calendar.YEAR) - start.get(Calendar.YEAR);
    }

    public String getFormattedSalary() {
        return String.format("$%.2f", salary);
    }

    public void setFullName(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length >= 2) {
            this.firstName = parts[0];
            this.lastName = parts[1];
        }
    }

    @Override
    public String toString() {
        return employeeId + " - " + getFullName() + " (" + department + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean that = (EmployeeBean) o;
        return Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    public static void main(String[] args) {
        EmployeeBean emp = new EmployeeBean("E101", "John", "Doe", 60000,
                "IT", new Date(), true);
        System.out.println(emp);
        System.out.println("Full Name: " + emp.getFullName());
        System.out.println("Years of Service: " + emp.getYearsOfService());
    }
}
