package week11.labProblems;
import java.util.*;

public class BalancedParentheses {
    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!((top == '(' && ch == ')') ||
                      (top == '{' && ch == '}') ||
                      (top == '[' && ch == ']')))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "{[()()]}";
        String s2 = "{[(])}";
        System.out.println(s1 + " → " + (isBalanced(s1) ? "Balanced" : "Not Balanced"));
        System.out.println(s2 + " → " + (isBalanced(s2) ? "Balanced" : "Not Balanced"));
    }
}
