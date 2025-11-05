package Week4.PraticeProblems;

class AudioMixer {
    private int volume;
    private int bass;
    private int treble;

    public AudioMixer() {
        this(50, 50, 50);
    }

    public AudioMixer(int volume) {
        this(volume, 50, 50);
    }

    public AudioMixer(int volume, int bass) {
        this(volume, bass, 50);
    }

    public AudioMixer(int volume, int bass, int treble) {
        this.volume = volume;
        this.bass = bass;
        this.treble = treble;
    }

    public void display() {
        System.out.println("Volume: " + volume + " | Bass: " + bass + " | Treble: " + treble);
    }
}

public class Q3Main {
    public static void main(String[] args) {
        AudioMixer a1 = new AudioMixer();
        AudioMixer a2 = new AudioMixer(70);
        AudioMixer a3 = new AudioMixer(80, 60);
        AudioMixer a4 = new AudioMixer(90, 70, 65);
        a1.display();
        a2.display();
        a3.display();
        a4.display();
    }
}
