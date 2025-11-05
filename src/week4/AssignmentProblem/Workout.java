package Week4.AssignmentProblem;

class Workout {
    private String activityName;
    private int durationInMinutes;
    private int caloriesBurned;

    public Workout() {
        this.activityName = "Walking";
        this.durationInMinutes = 30;
        this.caloriesBurned = 100;
    }

    public Workout(String activityName) {
        this.activityName = activityName;
        this.durationInMinutes = 30;
        this.caloriesBurned = durationInMinutes * 5;
    }

    public Workout(String activityName, int durationInMinutes) {
        this.activityName = activityName;
        this.durationInMinutes = durationInMinutes;
        this.caloriesBurned = durationInMinutes * 5;
    }

    public void displayWorkout() {
        System.out.println("Activity: " + activityName + " | Duration: " + durationInMinutes + " mins | Calories: " + caloriesBurned);
    }
}

public class Problem5Main {
    public static void main(String[] args) {
        Workout w1 = new Workout();
        Workout w2 = new Workout("Running");
        Workout w3 = new Workout("Cycling", 45);

        w1.displayWorkout();
        w2.displayWorkout();
        w3.displayWorkout();
    }
}

