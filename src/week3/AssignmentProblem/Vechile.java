package Week3.AssignmentProblem;

import java.util.*;

class Vehicle {
    private String vehicleId, brand, model, fuelType, currentStatus;
    private int year;
    private double mileage;
    private static int counter = 1;

    public Vehicle(String brand, String model, int year, double mileage, String fuelType) {
        vehicleId = "V" + String.format("%03d", counter++);
        this.brand = brand; this.model = model; this.year = year; this.mileage = mileage; this.fuelType = fuelType;
        currentStatus = "Available";
    }

    public void assignDriver(String driver) { currentStatus = "Assigned to " + driver; }
    public void scheduleMaintenance() { currentStatus = "Maintenance"; }
    public void updateMileage(double miles) { mileage += miles; }
    public String toString() { return vehicleId+" | "+brand+" "+model+" | "+year+" | "+mileage+" km | "+fuelType+" | "+currentStatus; }
}

class Driver {
    private String driverId, driverName, licenseType;
    private static int counter = 1;

    public Driver(String name, String license) { driverId = "D" + String.format("%03d", counter++); driverName = name; licenseType = license; }
    public String getDriverName() { return driverName; }
}

public class Assignment7Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Toyota","Innova",2022,12000,"Diesel");
        Vehicle v2 = new Vehicle("Tata","TruckX",2020,50000,"Diesel");
        Driver d1 = new Driver("Alice","Heavy");
        v1.assignDriver(d1.getDriverName());
        v2.scheduleMaintenance();
        v1.updateMileage(200);
        System.out.println(v1);
        System.out.println(v2);
    }
}
