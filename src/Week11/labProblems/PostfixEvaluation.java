package week11.labProblems;
import java.util.*;

public class PostfixEvaluation {
    public static int evaluate(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.split(" ");
        for (String t : tokens) {
            if (t.matches("\d+")) stack.push(Integer.parseInt(t));
            else {
                int b = stack.pop();
                int a = stack.pop();
                switch (t) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String expr = "6 3 2 + *";
        System.out.println("Postfix: " + expr);
        System.out.println("Result: " + evaluate(expr));
    }
}
