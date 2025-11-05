package Week6.AssignmentProblems;

class Weather {
    protected String condition;
    public Weather(String condition) {
        this.condition = condition;
        System.out.println("Weather: " + condition);
    }
    public void show() {
        System.out.println("General weather: " + condition);
    }
}

class Storm extends Weather {
    protected int speed;
    public Storm(String condition, int speed) {
        super(condition);
        this.speed = speed;
        System.out.println("Storm with speed: " + speed);
    }
    @Override
    public void show() {
        System.out.println("Storm: " + condition + " with speed " + speed);
    }
}

class Thunderstorm extends Storm {
    private boolean lightning;
    public Thunderstorm(String condition, int speed, boolean lightning) {
        super(condition, speed);
        this.lightning = lightning;
        System.out.println("Thunderstorm with lightning: " + lightning);
    }
    @Override
    public void show() {
        System.out.println("Thunderstorm: " + condition + ", Speed: " + speed + ", Lightning: " + lightning);
    }
}

class Sunshine extends Weather {
    private int temperature;
    public Sunshine(String condition, int temperature) {
        super(condition);
        this.temperature = temperature;
        System.out.println("Sunshine with temp: " + temperature);
    }
    @Override
    public void show() {
        System.out.println("Sunshine: " + condition + ", Temperature: " + temperature);
    }
}

public class HWProblem6 {
    public static void main(String[] args) {
        Weather[] weatherArray = {
                new Thunderstorm("Rainy", 80, true),
                new Sunshine("Clear Sky", 30),
                new Storm("Windy", 60)
        };
        for (Weather w : weatherArray) {
            w.show();
        }
    }
}
