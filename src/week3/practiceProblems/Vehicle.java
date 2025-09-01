package week3.practiceProblems;

public class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    public void startVehicle() {
        System.out.println(make + " " + model + " is starting...");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " is stopping...");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled. Current fuel: " + fuelLevel + "L");
    }

    public void displayVehicleInfo() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year + ", Fuel Level: " + fuelLevel + "L");
    }

    public static void main(String[] args) {
        // Subclasses
        class Car extends Vehicle {
            public Car(String make, String model, int year, double fuelLevel) {
                super(make, model, year, fuelLevel);
            }

            @Override
            public void startVehicle() {
                System.out.println("Car " + make + " " + model + " is roaring to life!");
            }
        }

        class Truck extends Vehicle {
            public Truck(String make, String model, int year, double fuelLevel) {
                super(make, model, year, fuelLevel);
            }

            @Override
            public void startVehicle() {
                System.out.println("Truck " + make + " " + model + " is rumbling on...");
            }
        }

        class Motorcycle extends Vehicle {
            public Motorcycle(String make, String model, int year, double fuelLevel) {
                super(make, model, year, fuelLevel);
            }

            @Override
            public void startVehicle() {
                System.out.println("Motorcycle " + make + " " + model + " is revving up!");
            }
        }

        Vehicle v1 = new Car("Honda", "City", 2022, 30);
        Vehicle v2 = new Truck("Tata", "Ace", 2020, 50);
        Vehicle v3 = new Motorcycle("Yamaha", "R15", 2023, 15);

        Vehicle[] fleet = {v1, v2, v3};

        for (Vehicle v : fleet) {
            v.startVehicle();
            v.refuel(10);
            v.displayVehicleInfo();
            System.out.println("-------------------");
        }

        /*
         * Reusability:
         * The base class Vehicle defines shared properties and methods.
         * Subclasses reuse and extend this logic without rewriting everything.
         *
         * Extensibility:
         * You can easily add new types like ElectricCar or Bus by extending Vehicle.
         *
         * Benefits over separate classes:
         * - Less code duplication
         * - Easier maintenance
         * - Unified interface for handling different vehicle types
         */
    }
}
