package week4.practiceProblems;

public class SmartDevices {
    private String deviceName;
    private String location;
    private boolean isOnline;
    private double powerConsumption;
    private final String[] connectedDevices;
    private int connectionCount;

    public SmartDevices(String deviceName, String location, boolean isOnline, double powerConsumption) {
        this.deviceName = deviceName;
        this.location = location;
        this.isOnline = isOnline;
        this.powerConsumption = powerConsumption;
        this.connectedDevices = new String[5];
        this.connectionCount = 0;
    }

    public void updateLocation(String location) {
        this.location = location;
        System.out.println(this.deviceName + " moved to " + this.location);
    }

    public void updatePowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
        System.out.println("Power consumption updated for " + this.deviceName);
    }

    public SmartDevices setOnline(boolean isOnline) {
        this.isOnline = isOnline;
        return this;
    }

    public SmartDevices connectToDevice(String deviceName) {
        if (this.connectionCount < this.connectedDevices.length) {
            this.connectedDevices[this.connectionCount] = deviceName;
            this.connectionCount++;
            System.out.println(this.deviceName + " connected to " + deviceName);
        }
        return this;
    }

    public SmartDevices rename(String deviceName) {
        String oldName = this.deviceName;
        this.deviceName = deviceName;
        System.out.println("Device renamed from " + oldName + " to " + this.deviceName);
        return this;
    }

    public void displayDeviceInfo() {
        System.out.println("\n=== " + this.deviceName + " INFO ===");
        System.out.println("Location: " + this.location);
        System.out.println("Status: " + (this.isOnline ? "Online" : "Offline"));
        System.out.println("Power: " + this.powerConsumption + "W");
        System.out.println("Connections: " + this.connectionCount);
        for (int i = 0; i < this.connectionCount; i++) {
            System.out.println(" -> " + this.connectedDevices[i]);
        }
    }

    public void performInitialSetup() {
        this.setOnline(true);
        System.out.println(this.deviceName + " initial setup completed");
    }

    public static void main(String[] args) {
        System.out.println("=== SMART HOME DEVICE NETWORK ===");

        SmartDevices device1 = new SmartDevices("ThermoGuard", "Living Room", false, 15.5);
        SmartDevices device2 = new SmartDevices("LightSync", "Bedroom", true, 8.2);
        SmartDevices device3 = new SmartDevices("AquaSense", "Bathroom", false, 12.0);

        device1.performInitialSetup();
        device1.connectToDevice("Alexa").rename("Climate Hub").updateLocation("Hallway");
        device2.setOnline(false).connectToDevice("Google Home").rename("Mood Lights");
        device3.setOnline(true).connectToDevice("Smart Mirror").connectToDevice("Water Monitor");

        device1.displayDeviceInfo();
        device2.displayDeviceInfo();
        device3.displayDeviceInfo();
    }
}