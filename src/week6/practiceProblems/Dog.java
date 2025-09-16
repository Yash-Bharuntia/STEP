package week6.practiceProblems;

public class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;

    public Dog() {
        super("Dog", "Domestic", 13, false, "Varies", 60);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 7;
        this.favoriteActivity = "Playing fetch";
        System.out.println("Dog constructor: Creating default dog");
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
             other.furColor, other.gestationPeriod,
             other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
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
        System.out.println("Loyalty level: " + loyaltyLevel + "/10");
    }

    public void demonstrateInheritance() {
        System.out.println("--- Demonstrating Inheritance Chain ---");
        super.move();
        this.move();
        super.eat();
        this.eat();
        this.sleep();
    }

    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.bark();
        d1.fetch();
        d1.showLoyalty();
        d1.demonstrateInheritance();

        System.out.println();

        Dog d2 = new Dog("Dog", "House", 15, false, "Brown", 65,
                         "Labrador", true, 10, "Swimming");
        d2.eat();
        d2.sleep();
        d2.move();

        System.out.println();

        Dog d3 = new Dog(d2);
        d3.showLoyalty();

        System.out.println("d3 instanceof Dog: " + (d3 instanceof Dog));
        System.out.println("d3 instanceof Mammal: " + (d3 instanceof Mammal));
        System.out.println("d3 instanceof Animal: " + (d3 instanceof Animal));
    }
}
