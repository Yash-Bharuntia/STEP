package Week9.LabProblem;

class Car {
    String brand;
    String model;
    double price;
    Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Car[Brand=" + brand + ", Model=" + model + ", Price=" + price + "]";
    }
}
public class Main2 {
    public static void main(String[] args) {
        Car c = new Car("Tesla", "Model S", 80000);
        System.out.println(c);
        System.out.println(c.getClass().getName());
    }
}