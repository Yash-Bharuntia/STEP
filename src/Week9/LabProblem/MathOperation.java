package Week9.LabProblem;

interface MathOperation {
    int operate(int a, int b);
}
class Calculator {
    static class Operation {
        int add(int a, int b) {
            return a + b;
        }
    }
    void performOperations() {
        class Subtraction {
            int subtract(int a, int b) {
                return a - b;
            }
        }
        MathOperation multiply = new MathOperation() {
            public int operate(int a, int b) {
                return a * b;
            }
        };
        Operation op = new Operation();
        Subtraction sub = new Subtraction();
        System.out.println("Addition: " + op.add(10, 5));
        System.out.println("Subtraction: " + sub.subtract(10, 5));
        System.out.println("Multiplication: " + multiply.operate(10, 5));
    }
}
public class Main6 {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.performOperations();
    }
}