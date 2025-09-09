package week4.labProblems;

abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    public MagicalStructure(String structureName) {
        this(structureName, 50, "Unknown", true);
    }

    public MagicalStructure(String structureName, int magicPower) {
        this(structureName, magicPower, "Unknown", true);
    }

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    private final int spellCapacity;
    private final String[] knownSpells;

    public WizardTower(String name) {
        super(name, 80, "Hilltop", true);
        this.spellCapacity = 5;
        this.knownSpells = new String[]{"Fireball", "Shield"};
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts a spell from its tower!");
    }
}

class EnchantedCastle extends MagicalStructure {
    private final int defenseRating;
    private final boolean hasDrawbridge;

    public EnchantedCastle(String name) {
        super(name, 100, "Valley", true);
        this.defenseRating = 200;
        this.hasDrawbridge = true;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " strengthens its magical defenses!");
    }
}

class MysticLibrary extends MagicalStructure {
    private final int bookCount;
    private final String ancientLanguage;

    public MysticLibrary(String name) {
        super(name, 70, "Forest", true);
        this.bookCount = 1000;
        this.ancientLanguage = "Latin";
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " shares magical knowledge!");
    }
}

class DragonLair extends MagicalStructure {
    private final String dragonType;
    private final int treasureValue;

    public DragonLair(String name) {
        super(name, 120, "Mountain", true);
        this.dragonType = "Fire Dragon";
        this.treasureValue = 10000;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " unleashes dragon fury!");
    }
}

public class KingdomBuilder {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return s1.isActive && s2.isActive;
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower)
            return attacker.structureName + " wins against " + defender.structureName;
        else if (attacker.magicPower < defender.magicPower)
            return defender.structureName + " wins against " + attacker.structureName;
        else
            return "It's a draw!";
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }

    public static void main(String[] args) {
        WizardTower tower = new WizardTower("Mystic Tower");
        EnchantedCastle castle = new EnchantedCastle("Royal Castle");
        MysticLibrary library = new MysticLibrary("Ancient Library");
        DragonLair lair = new DragonLair("Dragon's Den");

        MagicalStructure[] kingdom = {tower, castle, library, lair};

        for (MagicalStructure s : kingdom) {
            s.castMagicSpell();
        }

        System.out.println(performMagicBattle(tower, lair));
        System.out.println("Total Magic Power: " + calculateKingdomMagicPower(kingdom));
    }
}
