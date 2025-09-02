package week4.practiceProblems;

public class gameController {
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    public gameController() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    public gameController(String controllerBrand, String connectionType,
                          boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        this.batteryLevel = (batteryLevel >= 0 && batteryLevel <= 100) ? batteryLevel : 100;
        this.sensitivity = (sensitivity >= 0.1 && sensitivity <= 3.0) ? sensitivity : 1.0;
    }

    public gameController(String brand, String connectionType) {
        this.controllerBrand = brand;
        this.connectionType = connectionType;
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("Brand: " + controllerBrand);
        System.out.println("Connection: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Enabled" : "Disabled"));
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
        System.out.println("-----------------------------");
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        gameController defaultController = new gameController();
        gameController customController = new gameController("XPro Elite", "Bluetooth", false, 85, 2.5);
        gameController quickSetupController = new gameController("SpeedPad", "Wireless");

        defaultController.displayConfiguration();
        defaultController.calibrateController();
        defaultController.testVibration();

        customController.displayConfiguration();
        customController.calibrateController();
        customController.testVibration();

        quickSetupController.displayConfiguration();
        quickSetupController.calibrateController();
        quickSetupController.testVibration();
    }
}
