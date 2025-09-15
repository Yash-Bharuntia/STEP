import java.time.LocalDate;
import java.util.*;

final class AcademicRecord {
    private final String studentId;
    private final String major;
    private final LocalDate enrollmentDate;
    private final Map<String, String> completedCourses; // course -> grade
    private final double cumulativeGPA;
    private final String[] academicHonors;

    public AcademicRecord(String studentId, String major, LocalDate enrollmentDate,
                          Map<String,String> completedCourses, double cumulativeGPA, String[] academicHonors) {
        this.studentId = Objects.requireNonNull(studentId);
        this.major = major;
        this.enrollmentDate = enrollmentDate;
        this.completedCourses = new HashMap<>(completedCourses);
        this.cumulativeGPA = cumulativeGPA;
        this.academicHonors = Arrays.copyOf(academicHonors, academicHonors.length);
    }

    public String getStudentId() { return studentId; }
    public String getMajor() { return major; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public Map<String,String> getCompletedCourses() { return new HashMap<>(completedCourses); }
    public double getCumulativeGPA() { return cumulativeGPA; }
    public String[] getAcademicHonors() { return Arrays.copyOf(academicHonors, academicHonors.length); }

    public final boolean meetsPrerequisites(String courseCode) {
        // simple example: check if courseCode exists in completedCourses
        return completedCourses.containsKey(courseCode);
    }

    @Override
    public String toString() {
        return "Record:" + studentId + " GPA:" + cumulativeGPA;
    }
}

class Student {
    private final String studentId;
    private final AcademicRecord academicRecord;
    private String currentName;
    private String email;
    private String phoneNumber;
    private String currentAddress;
    private String emergencyContact;

    public Student(String studentId, AcademicRecord record, String name) {
        this.studentId = studentId;
        this.academicRecord = record;
        this.currentName = name;
    }

    String getAcademicStanding() { // package-private
        return "GPA:" + academicRecord.getCumulativeGPA();
    }

    public String getContactInfo() {
        return currentName + " <" + email + ">";
    }

    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phone) { this.phoneNumber = phone; }
    public void setCurrentAddress(String addr) { this.currentAddress = addr; }

    @Override
    public String toString() { return studentId + " - " + currentName; }
}

final class Course {
    private final String courseCode;
    private final String title;
    private final int creditHours;
    private final String[] prerequisites;

    public Course(String courseCode, String title, int creditHours, String[] prerequisites) {
        this.courseCode = courseCode;
        this.title = title;
        this.creditHours = creditHours;
        this.prerequisites = Arrays.copyOf(prerequisites, prerequisites.length);
    }

    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public int getCreditHours() { return creditHours; }
    public String[] getPrerequisites() { return Arrays.copyOf(prerequisites, prerequisites.length); }

    @Override public String toString() { return courseCode + ": " + title; }
}

class Professor {
    private final String facultyId;
    private final String department;
    private final List<String> qualifications;

    public Professor(String facultyId, String department, List<String> qualifications) {
        this.facultyId = facultyId;
        this.department = department;
        this.qualifications = new ArrayList<>(qualifications);
    }
}

class Classroom {
    private final String roomNumber;
    private final int capacity;
    private final String[] equipment;

    public Classroom(String roomNumber, int capacity, String[] equipment) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.equipment = Arrays.copyOf(equipment, equipment.length);
    }
}

class RegistrationSystem {
    private final Map<String, Student> enrolledStudents = new HashMap<>();
    private final Map<String, Course> availableCourses = new HashMap<>();
    private static final int MAX_COURSES = 5;

    public void addCourse(Course c) { availableCourses.put(c.getCourseCode(), c); }

    public boolean enrollStudent(Object studentObj, Object courseObj) {
        if (!(studentObj instanceof Student) || !(courseObj instanceof Course)) return false;
        Student student = (Student) studentObj;
        Course course = (Course) courseObj;

        // simple prerequisite check using academic record
        if (!student.academicRecord.meetsPrerequisites(course.getCourseCode())) {
            // allow enrollment if student has space
            enrolledStudents.put(student.toString(), student);
            return true;
        }
        enrolledStudents.put(student.toString(), student);
        return true;
    }

    public static void main(String[] args) {
        Map<String,String> completed = Map.of("CS101","A", "MATH101","B");
        AcademicRecord rec = new AcademicRecord("S100","CSE", LocalDate.of(2022,8,15), completed, 8.5, new String[] {"Honors"});
        Student s = new Student("S100", rec, "Bob");
        s.setEmail("bob@example.com");

        Course c1 = new Course("CS201","Data Structures",3, new String[] {"CS101"});
        RegistrationSystem rs = new RegistrationSystem();
        rs.addCourse(c1);
        boolean enrolled = rs.enrollStudent(s, c1);

        System.out.println("Enrolled: " + enrolled);
        System.out.println("Academic Standing: " + s.getAcademicStanding());
    }
}