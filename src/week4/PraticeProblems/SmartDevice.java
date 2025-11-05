package Week4.PraticeProblems;

class SmartDevice {
    private String name;
    private boolean powerOn;

    public SmartDevice(String name) {
        this.name = name;
        this.powerOn = false;
    }

    public SmartDevice turnOn() {
        powerOn = true;
        return this;
    }

    public SmartDevice turnOff() {
        powerOn = false;
        return this;
    }

    public void display() {
        System.out.println(name + " | Power: " + (powerOn ? "ON" : "OFF"));
    }
}

public class Q4Main {
    public static void main(String[] args) {
        SmartDevice d1 = new SmartDevice("Fan");
        d1.turnOn().display();
        d1.turnOff().display();
    }
}
