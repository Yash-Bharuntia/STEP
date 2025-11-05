package Week7.AssignmentProblem;

public class OnlineLearningPlatform {

    // Parent Class
    abstract static class Course {
        String title;
        String instructor;

        public Course(String title, String instructor) {
            this.title = title;
            this.instructor = instructor;
        }

        public void displayInfo() {
            System.out.println("Course: " + title + " | Instructor: " + instructor);
        }

        // Abstract method must be implemented by children
        abstract void displayProgress();
    }

    // Child Class 1
    static class VideoCourse extends Course {
        double percentageCompleted;
        int hoursWatched;

        public VideoCourse(String title, String instructor, double percentage, int hours) {
            super(title, instructor);
            this.percentageCompleted = percentage;
            this.hoursWatched = hours;
        }

        @Override // Override parent's method
        public void displayProgress() {
            displayInfo();
            System.out.printf("  └ Progress: %.1f%% complete (%d hours watched).%n", percentageCompleted, hoursWatched);
        }
    }

    // Child Class 2
    static class InteractiveCourse extends Course {
        int quizScore;
        int projectsCompleted;

        public InteractiveCourse(String title, String instructor, int score, int projects) {
            super(title, instructor);
            this.quizScore = score;
            this.projectsCompleted = projects;
        }

        @Override
        public void displayProgress() {
            displayInfo();
            System.out.printf("  └ Progress: Avg. Quiz Score: %d%% | Projects Done: %d.%n", quizScore, projectsCompleted);
        }
    }

    // Child Class 3
    static class CertificationCourse extends Course {
        int examAttempts;
        boolean isCertified;

        public CertificationCourse(String title, String instructor, int attempts, boolean certified) {
            super(title, instructor);
            this.examAttempts = attempts;
            this.isCertified = certified;
        }

        @Override
        public void displayProgress() {
            displayInfo();
            String status = isCertified ? "Achieved" : "In Progress";
            System.out.printf("  └ Certification Status: %s (Attempts: %d).%n", status, examAttempts);
        }
    }

    public static void main(String[] args) {
        Course video = new VideoCourse("Java Mastery", "Dr. Code", 75.5, 12);
        Course interactive = new InteractiveCourse("SQL for Beginners", "Data Dave", 92, 5);
        Course cert = new CertificationCourse("Cloud Practitioner", "Cloud Guru", 1, true);

        video.displayProgress();
        interactive.displayProgress();
        cert.displayProgress();
    }
}
