package Week3.AssignmentProblem;

import java.util.*;

class Patient {
    private String patientId, patientName, gender, contact;
    private int age;
    private static int counter = 1;

    public Patient(String name, int age, String gender, String contact) {
        patientId = "P" + String.format("%03d", counter++);
        patientName = name; this.age = age; this.gender = gender; this.contact = contact;
    }

    public String getName() { return patientName; }
    public String getId() { return patientId; }
}

class Doctor {
    private String doctorId, doctorName, specialization;
    private static int counter = 1;

    public Doctor(String name, String spec) {
        doctorId = "D" + String.format("%03d", counter++);
        doctorName = name; specialization = spec;
    }

    public String getName() { return doctorName; }
}

class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date, time, status;
    private double bill;
    private static int counter = 1;

    public Appointment(Patient p, Doctor d, String date, String time, String type) {
        appointmentId = "A" + String.format("%03d", counter++);
        patient = p; doctor = d; this.date = date; this.time = time; status = "Scheduled";
        if(type.equals("Consultation")) bill = 500; else if(type.equals("Follow-up")) bill = 300; else if(type.equals("Emergency")) bill = 1000;
    }

    public void cancel() { status = "Cancelled"; }
    public void generateBill() { System.out.println("Appointment: "+appointmentId+" | Patient: "+patient.getName()+" | Doctor: "+doctor.getName()+" | Bill: "+bill); }
}

public class Assignment8Main {
    public static void main(String[] args) {
        Patient p1 = new Patient("Alice",30,"F","99999");
        Doctor d1 = new Doctor("Dr. Bob","Cardiology");
        Appointment a1 = new Appointment(p1,d1,"2025-09-10","10:00","Consultation");
        a1.generateBill();
        a1.cancel();
        Appointment a2 = new Appointment(p1,d1,"2025-09-11","11:00","Emergency");
        a2.generateBill();
    }
}
