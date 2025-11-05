package Week8.LabProblems;

abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    public abstract void startEngine();
}

interface Maintainable {
    void serviceInfo();
}

class Car extends Vehicle implements Maintainable {
    private String model;

    public Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started. Model: " + model + ", Fuel: " + fuelType + ", Speed: " + speed + " km/h");
    }

    @Override
    public void serviceInfo() {
        System.out.println("Service every 6 months or 10,000 km.");
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        Car car = new Car(180, "Petrol", "Honda City");
        car.startEngine();
        car.serviceInfo();
    }
}
