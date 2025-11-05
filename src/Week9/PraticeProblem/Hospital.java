package Week9.PraticeProblem;

// File: Hospital.java
public class Hospital {
    private String name;

    public Hospital(String name) {
        this.name = name;
    }

    public class Department {
        private String deptName;
        public Department(String deptName) { this.deptName = deptName; }

        public void showInfo() {
            System.out.println("Department: " + deptName + " | Hospital: " + name);
        }
    }

    public Department createDepartment(String deptName) {
        return new Department(deptName);
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        Hospital h = new Hospital("Apollo");
        Hospital.Department d1 = h.createDepartment("Cardiology");
        Hospital.Department d2 = h.createDepartment("Neurology");
        d1.showInfo();
        d2.showInfo();
    }
}
