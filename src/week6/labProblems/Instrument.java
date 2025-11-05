package Week6.LabProblems;

Q.5
class Instrument {
    protected String name;
    protected String material;

    public Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }

    public void display() {
        System.out.println("Instrument: " + name + ", Material: " + material);
    }
}

class Piano extends Instrument {
    private int keys;
    public Piano(String material, int keys) {
        super("Piano", material);
        this.keys = keys;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Keys: " + keys);
    }
}

class Guitar extends Instrument {
    private int strings;
    public Guitar(String material, int strings) {
        super("Guitar", material);
        this.strings = strings;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Strings: " + strings);
    }
}

class Drum extends Instrument {
    private String type;
    public Drum(String material, String type) {
        super("Drum", material);
        this.type = type;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Type: " + type);
    }
}

public class LabProblem5 {
    public static void main(String[] args) {
        Instrument[] instruments = {
                new Piano("Wood", 88),
                new Guitar("Metal", 6),
                new Drum("Leather", "Bass Drum")
        };

        for (Instrument i : instruments) {
            i.display();
            System.out.println("---------------");
        }
    }
}
