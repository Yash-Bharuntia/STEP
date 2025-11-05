package Week6.LabProblems;

class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
}

class Apple extends Fruit {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    public void displayDetails() {
        System.out.println("Apple Color: " + color);
        System.out.println("Apple Taste: " + taste);
        System.out.println("Apple Variety: " + variety);
    }
}

public class LabProblem1 {
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.displayDetails();
    }
}
