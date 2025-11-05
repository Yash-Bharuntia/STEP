package Week6.AssignmentProblems;

abstract class Food {
    public final void prepare() {
        wash();
        cook();
        serve();
    }

    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}

class Pizza extends Food {
    protected void wash() {
        System.out.println("Washing vegetables for pizza");
    }
    protected void cook() {
        System.out.println("Baking pizza in oven");
    }
    protected void serve() {
        System.out.println("Serving pizza slices");
    }
}

class Soup extends Food {
    protected void wash() {
        System.out.println("Washing ingredients for soup");
    }
    protected void cook() {
        System.out.println("Boiling soup on stove");
    }
    protected void serve() {
        System.out.println("Serving hot soup");
    }
}

public class HWProblem4 {
    public static void main(String[] args) {
        Food f1 = new Pizza();
        Food f2 = new Soup();
        f1.prepare();
        f2.prepare();
    }
}
