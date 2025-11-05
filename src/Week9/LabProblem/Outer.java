package Week9.LabProblem;

class Outer {
    private String message = "Hello from Inner Class";
    class Inner {
        void display() {
            System.out.println(message);
        }
    }
}
public class Main5 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }
}