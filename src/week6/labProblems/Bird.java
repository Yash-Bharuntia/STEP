package Week6.LabProblems;

class Bird {
    public void fly() {
        System.out.println("Bird is flying...");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguins can't fly, they swim instead!");
    }
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle soars high in the sky!");
    }
}

public class LabProblem3 {
    public static void main(String[] args) {
        Bird[] birds = {new Bird(), new Penguin(), new Eagle()};
        for (Bird b : birds) {
            b.fly();
        }
    }
}
