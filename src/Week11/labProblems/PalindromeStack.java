package week11.labProblems;
import java.util.*;

public class PalindromeStack {
    public static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : cleaned.toCharArray()) stack.push(c);
        StringBuilder rev = new StringBuilder();
        while (!stack.isEmpty()) rev.append(stack.pop());
        return cleaned.equals(rev.toString());
    }

    public static void main(String[] args) {
        String word = "Madam";
        System.out.println("Input: " + word);
        System.out.println("Result: " + (isPalindrome(word) ? "Palindrome" : "Not Palindrome"));
    }
}
