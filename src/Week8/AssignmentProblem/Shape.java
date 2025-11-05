package Week8.AssignmentProblem;

abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    public void displayInfo() {
        System.out.println("This is a shape with area and perimeter.");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        double a = Math.PI * radius * radius;
        System.out.println("Circle Area: " + a);
        return a;
    }

    @Override
    public double perimeter() {
        double p = 2 * Math.PI * radius;
        System.out.println("Circle Perimeter: " + p);
        return p;
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        double a = length * width;
        System.out.println("Rectangle Area: " + a);
        return a;
    }

    @Override
    public double perimeter() {
        double p = 2 * (length + width);
        System.out.println("Rectangle Perimeter: " + p);
        return p;
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        c.displayInfo();
        c.area();
        c.perimeter();

        System.out.println();

        Shape r = new Rectangle(4, 6);
        r.displayInfo();
        r.area();
        r.perimeter();
    }
}
