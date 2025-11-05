package Week9.PraticeProblem;

public class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;

    // Constructor
    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }

    // Getters
    public String getRegistrationNo() { return registrationNo; }
    public String getType() { return type; }
    public double getRatePerDay() { return ratePerDay; }

    // Override toString()
    @Override
    public String toString() {
        return "Vehicle: " + registrationNo +
                ", Type: " + type +
                ", Rate: $" + ratePerDay + "/day";
    }
}
public class VehicleRental {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        System.out.println(v1);

        Vehicle v2 = new Vehicle("MH14XY5678", "SUV", 2200);
        System.out.println(v2);

        System.out.println("Same reference? " + (v1 == v2));
        System.out.println("Same content? " + v1.equals(v2)); // false (not overridden yet)
    }
}
