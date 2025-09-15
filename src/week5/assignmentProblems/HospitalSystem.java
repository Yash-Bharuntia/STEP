import java.time.LocalDate;
import java.util.*;

final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies,
                         String[] medicalHistory, LocalDate birthDate, String bloodType) {
        this.recordId = Objects.requireNonNull(recordId);
        this.patientDNA = Objects.requireNonNull(patientDNA);
        this.allergies = Arrays.copyOf(allergies, allergies.length);
        this.medicalHistory = Arrays.copyOf(medicalHistory, medicalHistory.length);
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return Arrays.copyOf(allergies, allergies.length); }
    public String[] getMedicalHistory() { return Arrays.copyOf(medicalHistory, medicalHistory.length); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }

    public final boolean isAllergicTo(String substance) {
        return Arrays.asList(allergies).contains(substance);
    }

    @Override
    public String toString() {
        return "MedicalRecord{" + recordId + ", BloodType=" + bloodType + "}";
    }
}

class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;

    public Patient(String patientId, MedicalRecord record, String name) {
        this.patientId = patientId;
        this.medicalRecord = record;
        this.currentName = name;
    }

    String getBasicInfo() {
        return patientId + " - " + currentName + " (Room " + roomNumber + ")";
    }

    public String getPublicInfo() {
        return "Patient: " + currentName + ", Room " + roomNumber;
    }

    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    public void setAttendingPhysician(String physician) { this.attendingPhysician = physician; }
}

class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;

    public Doctor(String licenseNumber, String specialty, Set<String> certs) {
        this.licenseNumber = licenseNumber;
        this.specialty = specialty;
        this.certifications = new HashSet<>(certs);
    }
}

class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;

    public Nurse(String nurseId, String shift, List<String> qualifications) {
        this.nurseId = nurseId;
        this.shift = shift;
        this.qualifications = new ArrayList<>(qualifications);
    }
}

class Administrator {
    private final String adminId;
    private final List<String> accessPermissions;

    public Administrator(String adminId, List<String> accessPermissions) {
        this.adminId = adminId;
        this.accessPermissions = new ArrayList<>(accessPermissions);
    }
}

class HospitalSystem {
    private final Map<String, Patient> patientRegistry = new HashMap<>();
    private static final String POLICY_PRIVACY = "STRICT_PRIVACY";

    public boolean admitPatient(Patient patient, Object staff) {
        if (validateStaffAccess(staff, patient)) {
            patientRegistry.put(patient.getPublicInfo(), patient);
            return true;
        }
        return false;
    }

    private boolean validateStaffAccess(Object staff, Patient patient) {
        return (staff instanceof Doctor || staff instanceof Administrator);
    }

    public static void main(String[] args) {
        MedicalRecord record = new MedicalRecord("R001", "DNA123",
                new String[]{"Peanuts"}, new String[]{"Asthma"},
                LocalDate.of(1995, 5, 10), "O+");

        Patient p1 = new Patient("P001", record, "Alice");
        p1.setRoomNumber(101);
        p1.setAttendingPhysician("Dr. Smith");

        Doctor doc = new Doctor("LIC123", "Cardiology", Set.of("BLS", "ACLS"));
        HospitalSystem system = new HospitalSystem();
        System.out.println("Admit Result: " + system.admitPatient(p1, doc));
        System.out.println("Public Info: " + p1.getPublicInfo());
    }
}
