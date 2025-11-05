package week11.labProblems;
import java.util.*;

public class ReverseStringStack {
    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        StringBuilder rev = new StringBuilder();
        while (!stack.isEmpty()) rev.append(stack.pop());
        return rev.toString();
    }

    public static void main(String[] args) {
        String input = "HELLO";
        System.out.println("Input: " + input);
        System.out.println("Reversed: " + reverse(input));
    }
}
