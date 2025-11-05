package Week3.LabProblems;
class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName;
    private static int counter = 1;

    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = "V" + String.format("%03d", counter++);
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        totalVehicles++;
    }

    public double rentVehicle(int days) {
        if (isAvailable) {
            isAvailable = false;
            double cost = calculateRent(days);
            return cost;
        }
        return 0;
    }

    public void returnVehicle() {
        isAvailable = true;
    }

    public double calculateRent(int days) {
        double cost = rentPerDay * days;
        totalRevenue += cost;
        return cost;
    }

    public void displayVehicleInfo() {
        System.out.println(vehicleId + " " + brand + " " + model + " Rent: " + rentPerDay + " Available: " + isAvailable);
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static void displayCompanyStats() {
        System.out.println("Company: " + companyName + " Vehicles: " + totalVehicles + " Revenue: " + totalRevenue);
    }
}

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle.setCompanyName("ZoomCars");
        Vehicle v1 = new Vehicle("Toyota", "Innova", 2000);
        Vehicle v2 = new Vehicle("Honda", "City", 1500);
        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        double c1 = v1.rentVehicle(3);
        System.out.println("Rent: " + c1);
        v1.returnVehicle();
        Vehicle.displayCompanyStats();
    }
}
