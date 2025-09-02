package week4.practiceProblems;

public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    public AudioMixer() {
        this("StandardMix-8", 8, false);
    }

    public AudioMixer(String mixerModel, int numberOfChannels) {
        this(mixerModel, numberOfChannels, false);
    }

    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0);
    }

    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;
        this.connectedDevices = new String[numberOfChannels];
        this.deviceCount = 0;
        System.out.println("Constructor executed for: " + mixerModel);
    }

    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println(" Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");

        AudioMixer mixer1 = new AudioMixer();
        AudioMixer mixer2 = new AudioMixer("BassBoost-4", 4);
        AudioMixer mixer3 = new AudioMixer("EchoMaster-12", 12, true);
        AudioMixer mixer4 = new AudioMixer("ProMix-X", 16, true, 135.0);

        mixer1.connectDevice("Mic A");
        mixer1.connectDevice("Keyboard");

        mixer2.connectDevice("Guitar");
        mixer2.connectDevice("Drum Pad");
        mixer2.connectDevice("Mic B");
        mixer2.connectDevice("Sampler");

        mixer3.connectDevice("DJ Console");
        mixer3.connectDevice("Mic C");

        mixer4.connectDevice("Synth");
        mixer4.connectDevice("Mic D");
        mixer4.connectDevice("Loop Station");
        mixer4.connectDevice("FX Rack");

        mixer1.displayMixerStatus();
        mixer2.displayMixerStatus();
        mixer3.displayMixerStatus();
        mixer4.displayMixerStatus();

        System.out.println("\nConstructor chaining ensures consistent initialization:");
        System.out.println("→ No-arg → 2-param → 3-param → Full constructor");
    }
}