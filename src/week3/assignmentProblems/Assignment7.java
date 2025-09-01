package week3.assignmentProblems;

import java.util.*;
class Vehicle{
    String id;
    String brand;
    String model;
    int year;
    double mileage;
    String fuelType;
    String status;
    public Vehicle(String id,String brand,String model,int year,double mileage,String fuelType,String status){
        this.id=id;
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.mileage=mileage;
        this.fuelType=fuelType;
        this.status=status;
    }
}
class Bus extends Vehicle{
    int seatingCapacity;
    public Bus(String id,String brand,String model,int year,double mileage,String fuelType,String status,int seatingCapacity){
        super(id,brand,model,year,mileage,fuelType,status);
        this.seatingCapacity=seatingCapacity;
    }
}
class Truck extends Vehicle{
    double loadCapacity;
    public Truck(String id,String brand,String model,int year,double mileage,String fuelType,String status,double loadCapacity){
        super(id,brand,model,year,mileage,fuelType,status);
        this.loadCapacity=loadCapacity;
    }
}
class Car extends Vehicle{
    boolean ac;
    public Car(String id,String brand,String model,int year,double mileage,String fuelType,String status,boolean ac){
        super(id,brand,model,year,mileage,fuelType,status);
        this.ac=ac;
    }
}
class Driver{
    String id;
    String name;
    String license;
    String assignedVehicleId;
    double totalKm;
    public Driver(String id,String name,String license){
        this.id=id;
        this.name=name;
        this.license=license;
        this.assignedVehicleId="";
        this.totalKm=0;
    }
}
class Fleet{
    static int totalVehicles=0;
    static double fuelCostPerLiter=100;
    static String companyName="TransitCo";
    static double totalFuelUsed=0;
    ArrayList<Vehicle> vehicles=new ArrayList<>();
    ArrayList<Driver> drivers=new ArrayList<>();
    public void addVehicle(Vehicle v){
        vehicles.add(v);
        totalVehicles++;
    }
    public void addDriver(Driver d){
        drivers.add(d);
    }
    public Driver findDriver(String id){
        for(Driver d:drivers) if(d.id.equals(id)) return d;
        return null;
    }
    public Vehicle findVehicle(String id){
        for(Vehicle v:vehicles) if(v.id.equals(id)) return v;
        return null;
    }
    public void assignDriver(String driverId,String vehicleId){
        Driver d=findDriver(driverId);
        Vehicle v=findVehicle(vehicleId);
        if(d!=null && v!=null){
            d.assignedVehicleId=vehicleId;
            v.status="Assigned";
        }
    }
    public void logTrip(String vehicleId,double km,double fuelLiters){
        Vehicle v=findVehicle(vehicleId);
        if(v!=null){
            v.mileage+=km;
            totalFuelUsed+=fuelLiters;
        }
    }
    public void refuel(double liters){
        totalFuelUsed+=liters;
    }
    public void service(String vehicleId){
        Vehicle v=findVehicle(vehicleId);
        if(v!=null) v.status="Serviced";
    }
    public double getCost(){
        return totalFuelUsed*fuelCostPerLiter;
    }
    public static void setFuelCost(double c){ fuelCostPerLiter=c; }
    public static void setCompanyName(String n){ companyName=n; }
    public static void report(Fleet f){
        System.out.println(companyName+" Vehicles:"+totalVehicles+" FuelUsed:"+totalFuelUsed+" Cost:"+f.getCost());
    }
}
public class Assignment7{
    public static void main(String[] args){
        Fleet f=new Fleet();
        f.addVehicle(new Bus("V1","Tata","BusX",2019,50000,"Diesel","Available",40));
        f.addVehicle(new Truck("V2","Ashok","TruckY",2018,80000,"Diesel","Available",8.0));
        f.addVehicle(new Car("V3","Maruti","Swift",2022,12000,"Petrol","Available",true));
        f.addDriver(new Driver("D1","Ramesh","LMV"));
        f.addDriver(new Driver("D2","Sita","HMV"));
        f.assignDriver("D2","V2");
        f.logTrip("V2",350,40);
        f.logTrip("V1",120,20);
        Fleet.report(f);
        Fleet.setFuelCost(110);
        Fleet.report(f);
    }
}