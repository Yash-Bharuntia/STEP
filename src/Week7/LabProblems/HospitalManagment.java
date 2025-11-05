package Week7.LabProblems;

public class HospitalManagement {

    // Parent Class
    static class MedicalStaff {
        String staffId;
        String name;

        public MedicalStaff(String staffId, String name) {
            this.staffId = staffId;
            this.name = name;
        }

        public String getInfo() {
            return "ID: " + staffId + ", Name: " + name;
        }
    }

    // Child Classes
    static class Doctor extends MedicalStaff {
        public Doctor(String id, String name) { super(id, name); }
        public void diagnose() { /* ... */ }
    }

    static class Nurse extends MedicalStaff {
        public Nurse(String id, String name) { super(id, name); }
        public void administerMeds() { /* ... */ }
    }

    static class Administrator extends MedicalStaff {
        public Administrator(String id, String name) { super(id, name); }
    }

    // This method works with ANY MedicalStaff member
    public static void processPayroll(MedicalStaff staffMember) {
        // Upcasting happens implicitly when a Doctor/Nurse is passed in.
        System.out.println("Processing payroll for: " + staffMember.getInfo());
        // ...payroll logic here...
    }

    public static void main(String[] args) {
        Doctor doc = new Doctor("D001", "Dr. Strange");
        Nurse nurse = new Nurse("N012", "Nurse Joy");
        Administrator admin = new Administrator("A100", "Admin Alex");

        System.out.println("--- End of Month Payroll ---");
        processPayroll(doc);    // A Doctor is upcast to MedicalStaff
        processPayroll(nurse);  // A Nurse is upcast to MedicalStaff
        processPayroll(admin);  // An Administrator is upcast to MedicalStaff
    }
}
