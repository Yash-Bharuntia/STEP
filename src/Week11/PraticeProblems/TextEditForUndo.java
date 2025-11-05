package Week11.PraticeProblems;

import java.util.*;

public class TextEditForUndo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command (TYPE <word>/UNDO/PRINT/EXIT): ");
            String cmd = sc.next();

            if (cmd.equals("TYPE")) {
                String word = sc.next();
                stack.push(word); // push word to stack
            } else if (cmd.equals("UNDO")) {
                if (!stack.isEmpty()) stack.pop(); // pop last typed word
            } else if (cmd.equals("PRINT")) {
                // Display all words in the order typed
                for (String word : stack) System.out.print(word + " ");
                System.out.println();
            } else if (cmd.equals("EXIT")) {
                break;
            }
        }
        sc.close();
    }
}

