package Week6.LabProblems;

class Phone {
    protected String brand;
    protected String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone constructor called: " + brand + " " + model);
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);
        this.operatingSystem = operatingSystem;
        System.out.println("SmartPhone constructor called: " + operatingSystem);
    }
}

public class LabProblem2 {
    public static void main(String[] args) {
        SmartPhone sp1 = new SmartPhone("Apple", "iPhone 15", "iOS");
        SmartPhone sp2 = new SmartPhone("Samsung", "S24 Ultra", "Android");
    }
}
