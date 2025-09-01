package week3.labProblems;

class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;

    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static int rentalDays = 0;
    private static String companyName = "Default Rentals";
    public Vehicle(String brand, String model, double rentPerDay) {
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.vehicleId = generateVehicleId();
        totalVehicles++;
    }

    public static String generateVehicleId() {
        return String.format("V%03d", totalVehicles + 1);
    }

    public void rentVehicle(int days) {
        if (!isAvailable) {
            System.out.println("Vehicle " + vehicleId + " is not available.");
            return;
        }
        double rent = calculateRent(days);
        isAvailable = false;
        System.out.println("Vehicle " + vehicleId + " rented for " + days + " days. Rent: ₹" + rent);
    }

    public void returnVehicle() {
        if (isAvailable) {
            System.out.println("Vehicle " + vehicleId + " is already available.");
        } else {
            isAvailable = true;
            System.out.println("Vehicle " + vehicleId + " returned and is now available.");
        }
    }

    public double calculateRent(int days) {
        double rent = rentPerDay * days;
        totalRevenue += rent;
        rentalDays += days;
        return rent;
    }
    public void displayVehicleInfo() {
        System.out.println("Vehicle ID   : " + vehicleId);
        System.out.println("Brand        : " + brand);
        System.out.println("Model        : " + model);
        System.out.println("Rent/Day     : ₹" + rentPerDay);
        System.out.println("Available    : " + (isAvailable ? "Yes" : "No"));
        System.out.println("-----------------------------");
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        return rentalDays == 0 ? 0 : totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("=== " + companyName + " Stats ===");
        System.out.println("Total Vehicles     : " + totalVehicles);
        System.out.println("Total Revenue      : ₹" + totalRevenue);
        System.out.println("Total Rental Days  : " + rentalDays);
        System.out.println("Avg Rent/Day       : ₹" + getAverageRentPerDay());
        System.out.println("===============================");
    }
}

public class RentalSystem {
    public static void main(String[] args) {
        Vehicle.setCompanyName("Yash Vehicle Rentals");

        Vehicle v1 = new Vehicle("Toyota", "Innova", 1500);
        Vehicle v2 = new Vehicle("Honda", "City", 1200);
        Vehicle v3 = new Vehicle("Suzuki", "Swift", 1000);

        v1.rentVehicle(3);
        v2.rentVehicle(2);
        v1.returnVehicle();
        v3.rentVehicle(1);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();
        v3.displayVehicleInfo();

        Vehicle.displayCompanyStats();
    }

}
