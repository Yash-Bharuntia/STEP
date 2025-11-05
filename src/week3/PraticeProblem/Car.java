package Week3.PraticeProblem;
class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isRunning;

    // Constructor
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }

    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println(brand + " " + model + " engine started.");
        } else {
            System.out.println("Engine already running.");
        }
    }

    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            System.out.println(brand + " " + model + " engine stopped.");
        } else {
            System.out.println("Engine already stopped.");
        }
    }

    public int getAge() {
        return java.time.Year.now().getValue() - year;
    }

    public void displayInfo() {
        System.out.println("Car: " + brand + " " + model + " (" + year + "), Color: " + color + ", Running: " + isRunning);
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car c1 = new Car("Tesla", "Model S", 2022, "Black");
        Car c2 = new Car("Toyota", "Corolla", 2018, "White");

        c1.startEngine();
        c1.displayInfo();
        System.out.println("Age: " + c1.getAge() + " years");

        c2.displayInfo();
        c2.startEngine();
        c2.stopEngine();
    }
}
