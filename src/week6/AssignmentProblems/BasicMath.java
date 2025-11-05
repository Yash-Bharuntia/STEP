package Week6.AssignmentProblems;

class BasicMath {
    public int calculate(int a, int b) {
        return a + b;
    }
    public double calculate(double a, double b) {
        return a + b;
    }
    public int calculate(int a, int b, int c) {
        return a + b + c;
    }
}

class AdvancedMath extends BasicMath {
    public double calculate(double a, double b, double c) {
        return a * b * c;
    }
    public double calculate(int a, double b) {
        return a * b;
    }
}

public class HWProblem5 {
    public static void main(String[] args) {
        AdvancedMath am = new AdvancedMath();
        System.out.println(am.calculate(2, 3));
        System.out.println(am.calculate(2.5, 3.5));
        System.out.println(am.calculate(1, 2, 3));
        System.out.println(am.calculate(2.0, 3.0, 4.0));
        System.out.println(am.calculate(5, 2.5));
    }
}
