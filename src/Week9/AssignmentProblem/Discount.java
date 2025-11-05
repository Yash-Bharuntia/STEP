package Week9.AssignmentProblem;

interface Discount {
    double apply(double amount);
}
class Payment {
    void processTransaction(double amount) {
        class Validator {
            boolean isValid(double amt) {
                return amt > 0;
            }
        }
        Validator v = new Validator();
        if (!v.isValid(amount)) {
            System.out.println("Invalid Payment");
            return;
        }
        Discount d = new Discount() {
            public double apply(double amt) {
                return amt * 0.9;
            }
        };
        double discountedAmount = d.apply(amount);
        System.out.println("Original: " + amount);
        System.out.println("After Discount: " + discountedAmount);
    }
}
public class Main6 {
    public static void main(String[] args) {
        Payment p = new Payment();
        p.processTransaction(1000);
    }
}