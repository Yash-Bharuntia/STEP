package Week6.PraticeProblems;

public class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;
    private String registrationNumber;
    private boolean isRunning;

    public Vehicle() {
        this.brand = "Generic";
        this.model = "Base";
        this.year = 2000;
        this.engineType = "Petrol";
        this.registrationNumber = "REG00";
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = "REG00";
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return brand + " " + model + " (" + year + "), Engine: " + engineType
                + ", Reg: " + registrationNumber + ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine: " + engineType);
        System.out.println("Registration: " + registrationNumber);
        System.out.println("Running: " + isRunning);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isRunning() {
        return isRunning;
    }
}

class Car extends Vehicle {
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
        System.out.println("Car systems check");
        System.out.println("Air conditioning on");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    public static void main(String[] arg) {
        Car c1 = new Car();
        c1.start();
        c1.displaySpecs();
        c1.openTrunk();
        c1.playRadio();
        c1.stop();

        Car c2 = new Car("Toyota", "Corolla", 2024, "Hybrid", 4, "Hybrid", "Automatic");
        System.out.println(c2.getVehicleInfo());
        c2.start();
        c2.displaySpecs();
        System.out.println("Accessing protected fields: " + c2.brand + " " + c2.model + " " + c2.year + " " + c2.engineType);

        Vehicle v = new Car("Honda", "Civic", 2023, "Petrol", 4, "Petrol", "Manual");
        v.start();
        v.displaySpecs();
        if (v instanceof Car) {
            Car cc = (Car) v;
            cc.openTrunk();
        }
    }
}
