package Week6.PraticeProblems;
class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        System.out.println("Animal constructor: Creating " + species);
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
    }

    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return species + " | Habitat: " + habitat + " | Lifespan: " + lifespan + " | Wildlife: " + isWildlife;
    }
}

class Mammal extends Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;

    public Mammal(String species, String habitat, int lifespan, boolean isWildlife, String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        System.out.println("Mammal constructor: Adding mammal traits");
        this.furColor = furColor;
        this.hasWarmBlood = true;
        this.gestationPeriod = gestationPeriod;
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;

    public Dog() {
        super("Dog", "Home", 12, false, "Varies", 63);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 8;
        this.favoriteActivity = "Playing";
    }

    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }

    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
                other.furColor, other.gestationPeriod, other.breed,
                other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Loyalty level: " + loyaltyLevel);
    }

    public void demonstrateInheritance() {
        System.out.println(getAnimalInfo());
        eat();
        move();
        sleep();
        nurse();
        regulateTemperature();
        bark();
        fetch();
        showLoyalty();
    }
}

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.demonstrateInheritance();

        Dog d2 = new Dog("Canis lupus familiaris", "Home", 13, false, "Brown", 63, "Labrador", true, 10, "Fetch");
        d2.demonstrateInheritance();

        Dog d3 = new Dog(d2);
        d3.demonstrateInheritance();

        Animal a = d2;
        Mammal m = d2;

        System.out.println(a.getAnimalInfo());
        a.eat();
        a.move();
        a.sleep();

        m.move();
        m.nurse();
        m.regulateTemperature();

        System.out.println(d2 instanceof Dog);
        System.out.println(d2 instanceof Mammal);
        System.out.println(d2 instanceof Animal);
    }
}
