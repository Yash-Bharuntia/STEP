package week4.labProblems;

import java.util.*;

class VirtualPet {
    private final String petId;
    private final String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String stage;
    private boolean isGhost;

    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0;
    public VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 0, 60, 60, EVOLUTION_STAGES[1]);
    }

    public VirtualPet(String petName, String species) {
        this(petName, species, 1, 70, 70, EVOLUTION_STAGES[2]);
    }

    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stage = stage;
        this.isGhost = false;
        totalPetsCreated++;
    }

    public static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    private static String getRandomSpecies() {
        String[] speciesArr = {"Dragon", "Phoenix", "Unicorn", "Wolf", "Cat"};
        return speciesArr[new Random().nextInt(speciesArr.length)];
    }

    public void feedPet() {
        if (!isGhost) health = Math.min(100, health + 10);
    }

    public void playWithPet() {
        if (!isGhost) happiness = Math.min(100, happiness + 10);
    }

    public void healPet() {
        if (!isGhost) health = Math.min(100, health + 20);
    }

    public void simulateDay() {
        if (isGhost) return;
        age++;
        happiness = Math.max(0, happiness - new Random().nextInt(5));
        health = Math.max(0, health - new Random().nextInt(5));
        if (health == 0) {
            isGhost = true;
            species = "Ghost";
            stage = "Ghost";
        } else {
            evolvePet();
        }
    }

    public void evolvePet() {
        if (isGhost) return;
        int index = Math.min(age / 2, EVOLUTION_STAGES.length - 1);
        stage = EVOLUTION_STAGES[index];
    }

    public String getPetStatus() {
        return String.format("PetID: %s | Name: %s | Species: %s | Age: %d | Stage: %s | Happiness: %d | Health: %d",
                petId, petName, species, age, stage, happiness, health);
    }
}

public class VirtualPetSimulator {
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Fluffy");
        VirtualPet pet3 = new VirtualPet("Sparky", "Dragon");

        VirtualPet[] pets = {pet1, pet2, pet3};

        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day);
            for (VirtualPet pet : pets) {
                pet.simulateDay();
                pet.playWithPet();
                System.out.println(pet.getPetStatus());
            }
            System.out.println("----------------------------");
        }
    }
}
