package Week4.LabProblems;

class Kingdom {
    private String name;
    private int population;
    private double gold;
    private boolean hasMagic;

    public Kingdom() {
        this("Unknown", 0, 0.0, false);
    }

    public Kingdom(String name, int population) {
        this(name, population, 1000.0, false);
    }

    public Kingdom(String name, int population, double gold, boolean hasMagic) {
        this.name = name;
        this.population = population;
        this.gold = gold;
        this.hasMagic = hasMagic;
    }

    public void collectTaxes() {
        double collected = population * 2;
        gold += collected;
        System.out.println("Collected " + collected + " gold.");
    }

    public void trainArmy(int soldiers) {
        if (gold >= soldiers * 10) {
            gold -= soldiers * 10;
            population -= soldiers;
            System.out.println("Trained " + soldiers + " soldiers.");
        } else {
            System.out.println("Not enough gold to train soldiers.");
        }
    }

    public void castMagic() {
        if (hasMagic && gold >= 200) {
            gold -= 200;
            System.out.println("A magical blessing was cast!");
        } else {
            System.out.println("No magic available or insufficient gold.");
        }
    }

    public void display() {
        System.out.println("Kingdom: " + name + " | Population: " + population +
                " | Gold: " + gold + " | Magic: " + (hasMagic ? "Yes" : "No"));
    }
}

public class Q2Main {
    public static void main(String[] args) {
        Kingdom k1 = new Kingdom("Avalon", 500, 2000, true);
        Kingdom k2 = new Kingdom("Eldoria", 300);

        k1.display();
        k2.display();

        k1.collectTaxes();
        k1.trainArmy(50);
        k1.castMagic();
        k1.display();

        k2.collectTaxes();
        k2.trainArmy(20);
        k2.castMagic();
        k2.display();
    }
}

