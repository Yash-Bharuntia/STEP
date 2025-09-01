package week3.practiceProblems;

import java.util.Calendar;

public class Car {
    String brand, color, model;
    int year;
    boolean isRunning;
    Car(){
        brand = "";
        color = "";
        model = "";
        year = 0;
        isRunning = false;
    }
    Car(String brand, String color, String model, int year){
        this.brand = brand;
        this.color = color;
        this.model = model;
        this.year = year;
    }
    public void stopEngine(){
        isRunning = false;
        System.out.println("Car stopped");
    }
    public void startEngine(){
        isRunning = true;
        System.out.println("Car started");
    }
    void displayInfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
    void getAge(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("Age: " + (currentYear - year));
    }

    public static void main(String[] args){
        Car car1 = new Car();
        Car car2 = new Car("Honda", "Pink", "Verna", 2011);
        Car car3 = new Car("Hyundai", "Purple", "Creta", 2020);
        car1.startEngine();
        car2.startEngine();
        car3.startEngine();
        car1.stopEngine();
        car1.getAge();
        car2.getAge();
        car3.getAge();
        car1.displayInfo();
        car2.displayInfo();
        car3.displayInfo();

    }
}
