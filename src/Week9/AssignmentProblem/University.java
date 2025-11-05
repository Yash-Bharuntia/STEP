package Week9.AssignmentProblem;

class University {
    String universityName = "SRM University";
    class Department {
        void showDepartment() {
            System.out.println("Department of CSE - " + universityName);
        }
    }
    static class ExamCell {
        static void conductExam() {
            System.out.println("ExamCell: Conducting university exams.");
        }
    }
}
public class Main5 {
    public static void main(String[] args) {
        University u = new University();
        University.Department d = u.new Department();
        d.showDepartment();
        University.ExamCell.conductExam();
    }
}