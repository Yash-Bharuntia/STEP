package week6.practiceProblems;

public class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car systems check complete. Ready to drive!");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Doors: " + numberOfDoors + ", Fuel: " + fuelType +
                           ", Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.start();
        car1.displaySpecs();
        car1.openTrunk();
        car1.stop();
        System.out.println();

        Car car2 = new Car("Toyota", "Corolla", 2022, "Hybrid", 4, "Hybrid", "Automatic");
        car2.start();
        car2.playRadio();
        car2.displaySpecs();
        car2.stop();

        Vehicle v = new Car("Honda", "Civic", 2023, "Petrol", 4, "Petrol", "CVT");
        v.start();
        v.displaySpecs();
    }
}
