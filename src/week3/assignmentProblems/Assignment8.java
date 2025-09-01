package week3.assignmentProblems;

import java.util.*;
class Patient{
    String id;
    String name;
    int age;
    String gender;
    String phone;
    String[] ailments;
    String[] medicines;
    public Patient(String id,String name,int age,String gender,String phone,String[] ailments,String[] medicines){
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.phone=phone;
        this.ailments=ailments;
        this.medicines=medicines;
    }
}
class Doctor{
    String id;
    String name;
    String specialty;
    String[] slots;
    int experience;
    double fee;
    public Doctor(String id,String name,String specialty,String[] slots,int experience,double fee){
        this.id=id;
        this.name=name;
        this.specialty=specialty;
        this.slots=slots;
        this.experience=experience;
        this.fee=fee;
    }
}
class Appointment{
    String id;
    Patient patient;
    Doctor doctor;
    String type;
    String date;
    String bill;
    public Appointment(String id,Patient patient,Doctor doctor,String type,String date,String bill){
        this.id=id;
        this.patient=patient;
        this.doctor=doctor;
        this.type=type;
        this.date=date;
        this.bill=bill;
    }
}
class Hospital{
    static int totalPatients=0;
    static int totalDoctors=0;
    static String name="City Hospital";
    static double baseRate=200;
    ArrayList<Patient> patients=new ArrayList<>();
    ArrayList<Doctor> doctors=new ArrayList<>();
    ArrayList<Appointment> appointments=new ArrayList<>();
    public void addPatient(Patient p){
        patients.add(p);
        totalPatients++;
    }
    public void addDoctor(Doctor d){
        doctors.add(d);
        totalDoctors++;
    }
    public Doctor findDoctor(String id){
        for(Doctor d:doctors) if(d.id.equals(id)) return d;
        return null;
    }
    public Patient findPatient(String id){
        for(Patient p:patients) if(p.id.equals(id)) return p;
        return null;
    }
    public Appointment book(String pid,String did,String type,String date){
        Patient p=findPatient(pid);
        Doctor d=findDoctor(did);
        if(p==null || d==null) return null;
        double rate=baseRate;
        if(type.equals("Consultation")) rate=d.fee;
        if(type.equals("Follow-up")) rate=d.fee*0.5;
        if(type.equals("Emergency")) rate=d.fee*1.5;
        Appointment a=new Appointment("A"+(appointments.size()+1),p,d,type,date,"Rs."+rate);
        appointments.add(a);
        return a;
    }
    public boolean cancel(String aid){
        for(Appointment a:appointments){
            if(a.id.equals(aid)){
                appointments.remove(a);
                return true;
            }
        }
        return false;
    }
    public void listAppointments(){
        for(Appointment a:appointments) System.out.println(a.id+" "+a.patient.name+" "+a.doctor.name+" "+a.type+" "+a.bill);
    }
    public static void setName(String n){ name=n; }
    public static void setBaseRate(double r){ baseRate=r; }
    public static void totals(){
        System.out.println(name+" Patients:"+totalPatients+" Doctors:"+totalDoctors);
    }
}
public class Assignment8{
    public static void main(String[] args){
        Hospital h=new Hospital();
        h.addPatient(new Patient("P1","Ira",28,"F","9999",new String[]{"Cough"},new String[]{"Med1"}));
        h.addPatient(new Patient("P2","Dev",40,"M","8888",new String[]{"Fever"},new String[]{"Med2"}));
        h.addDoctor(new Doctor("D1","Dr. Rao","General",new String[]{"10:00","11:00"},10,500));
        h.addDoctor(new Doctor("D2","Dr. Sen","Cardio",new String[]{"12:00","13:00"},15,800));
        Appointment a1=h.book("P1","D1","Consultation","2025-09-02");
        Appointment a2=h.book("P2","D2","Emergency","2025-09-03");
        h.listAppointments();
        Hospital.totals();
        h.cancel(a1.id);
        h.listAppointments();
    }
}