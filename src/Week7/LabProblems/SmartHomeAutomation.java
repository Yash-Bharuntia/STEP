package Week7.LabProblems;

public class SmartHomeAutomation {

    // Parent and child classes
    interface SmartDevice { String getStatus(); }
    static class SmartTV implements SmartDevice {
        @Override public String getStatus() { return "SmartTV is ON."; }
        public void changeChannel(int channel) { System.out.println("📺 TV changed to channel " + channel + "."); }
    }
    static class SmartThermostat implements SmartDevice {
        @Override public String getStatus() { return "Thermostat is active."; }
        public void setTemperature(int degrees) { System.out.println("🌡 Thermostat set to " + degrees + "°C."); }
    }
    static class SmartSecuritySystem implements SmartDevice {
        @Override public String getStatus() { return "Security is ARMED."; }
        public void armSystem() { System.out.println(" Security system armed and monitoring."); }
    }

    public static void main(String[] args) {
        SmartDevice[] devices = {
                new SmartTV(),
                new SmartThermostat(),
                new SmartSecuritySystem()
        };

        // A central system processes all devices
        for (SmartDevice device : devices) {
            System.out.println("Device Status: " + device.getStatus());

            // Check the type BEFORE casting to call specific methods
            if (device instanceof SmartTV) {
                SmartTV tv = (SmartTV) device; // Safe downcast
                tv.changeChannel(101);
            } else if (device instanceof SmartThermostat) {
                SmartThermostat thermostat = (SmartThermostat) device; // Safe downcast
                thermostat.setTemperature(22);
            } else if (device instanceof SmartSecuritySystem) {
                SmartSecuritySystem security = (SmartSecuritySystem) device; // Safe downcast
                security.armSystem();
            }
            System.out.println("---");
        }
    }
}
