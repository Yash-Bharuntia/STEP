import java.time.LocalDate;
import java.util.*;

public final class ImmutableStudent {
    private final String studentId;
    private final String name;
    private final LocalDate birthDate;
    private final List<String> courses;
    private final Map<String, Double> grades;
    private final LocalDate graduationDate;

    public ImmutableStudent(String studentId, String name, LocalDate birthDate,
                            List<String> courses, Map<String, Double> grades,
                            LocalDate graduationDate) {
        this.studentId = studentId;
        this.name = name;
        this.birthDate = birthDate;
        this.courses = new ArrayList<>(courses);
        this.grades = new HashMap<>(grades);
        this.graduationDate = graduationDate;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public LocalDate getBirthDate() { return birthDate; }
    public List<String> getCourses() { return new ArrayList<>(courses); }
    public Map<String, Double> getGrades() { return new HashMap<>(grades); }
    public LocalDate getGraduationDate() { return graduationDate; }

    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    public double getGPA() {
        return grades.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public int getTotalCourses() { return courses.size(); }

    public boolean isGraduated() { return graduationDate != null; }

    public ImmutableStudent withGraduationDate(LocalDate date) {
        return new ImmutableStudent(studentId, name, birthDate, courses, grades, date);
    }

    public ImmutableStudent withAdditionalCourse(String course) {
        List<String> newCourses = new ArrayList<>(courses);
        newCourses.add(course);
        return new ImmutableStudent(studentId, name, birthDate, newCourses, grades, graduationDate);
    }

    public ImmutableStudent withGrade(String course, double grade) {
        Map<String, Double> newGrades = new HashMap<>(grades);
        newGrades.put(course, grade);
        return new ImmutableStudent(studentId, name, birthDate, courses, newGrades, graduationDate);
    }

    public ImmutableStudent withName(String newName) {
        return new ImmutableStudent(studentId, newName, birthDate, courses, grades, graduationDate);
    }

    @Override
    public String toString() {
        return studentId + " - " + name + " (" + getTotalCourses() + " courses)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableStudent)) return false;
        ImmutableStudent that = (ImmutableStudent) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(courses, that.courses) &&
                Objects.equals(grades, that.grades) &&
                Objects.equals(graduationDate, that.graduationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, birthDate, courses, grades, graduationDate);
    }

    public static void main(String[] args) {
        List<String> courses = new ArrayList<>(Arrays.asList("Math", "Science"));
        Map<String, Double> grades = new HashMap<>();
        grades.put("Math", 95.0);
        grades.put("Science", 87.0);

        ImmutableStudent student = new ImmutableStudent("S101", "Alice", LocalDate.of(2002, 5, 10), courses, grades, null);
        System.out.println(student);
        System.out.println("GPA: " + student.getGPA());

        ImmutableStudent graduated = student.withGraduationDate(LocalDate.of(2025, 6, 1));
        System.out.println("Graduated? " + graduated.isGraduated());
    }
}
