package Week4.LabProblems;

class VirtualPet {
    private String name;
    private int age;
    private String species;
    private int happiness;
    private int energy;

    public VirtualPet() {
        this("Unknown", 0, "Unknown", 50, 50);
    }

    public VirtualPet(String name, int age) {
        this(name, age, "Unknown", 50, 50);
    }

    public VirtualPet(String name, int age, String species, int happiness, int energy) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.happiness = happiness;
        this.energy = energy;
    }

    public void feed() {
        energy += 10;
        if (energy > 100) energy = 100;
    }

    public void play() {
        happiness += 10;
        energy -= 5;
        if (happiness > 100) happiness = 100;
        if (energy < 0) energy = 0;
    }

    public void evolve() {
        if (age >= 5 && happiness >= 70) {
            species = "Evolved " + species;
            System.out.println(name + " has evolved!");
        }
    }

    public void display() {
        System.out.println("Name: " + name + " | Age: " + age + " | Species: " + species +
                " | Happiness: " + happiness + " | Energy: " + energy);
    }
}

public class Q1Main {
    public static void main(String[] args) {
        VirtualPet p1 = new VirtualPet("Fluffy", 3, "Cat", 60, 70);
        VirtualPet p2 = new VirtualPet("Sparky", 6, "Dog", 80, 90);

        p1.display();
        p2.display();

        p1.feed();
        p1.play();
        p1.evolve();
        p1.display();

        p2.play();
        p2.evolve();
        p2.display();
    }
}
