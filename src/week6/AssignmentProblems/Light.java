package Week6.AssignmentProblems;

class Light {
    protected String type;

    public Light() {
        this("Generic Light");
        System.out.println("Light default constructor");
    }

    public Light(String type) {
        this.type = type;
        System.out.println("Light parameterized constructor: " + type);
    }
}

class LED extends Light {
    private int watts;

    public LED() {
        this("LED Light", 10);
        System.out.println("LED default constructor");
    }

    public LED(String type, int watts) {
        super(type);
        this.watts = watts;
        System.out.println("LED parameterized constructor: " + watts + "W");
    }
}

public class HWProblem1 {
    public static void main(String[] args) {
        LED l1 = new LED();
        LED l2 = new LED("Smart LED", 15);
    }
}
