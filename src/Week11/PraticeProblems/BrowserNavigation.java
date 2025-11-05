package Week11.PraticeProblems;

import java.util.*;

public class BrowserNavigation {
    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String current = "Home";

        while (true) {
            System.out.print("Command (VISIT/BACK/FORWARD/PRINT/EXIT): ");
            String cmd = sc.next();

            if (cmd.equals("VISIT")) {
                backStack.push(current);
                current = sc.next(); // visit new site
                forwardStack.clear(); // clear forward history
            } else if (cmd.equals("BACK")) {
                if (!backStack.isEmpty()) {
                    forwardStack.push(current);
                    current = backStack.pop();
                }
            } else if (cmd.equals("FORWARD")) {
                if (!forwardStack.isEmpty()) {
                    backStack.push(current);
                    current = forwardStack.pop();
                }
            } else if (cmd.equals("PRINT")) {
                System.out.println("Current Page: " + current);
            } else if (cmd.equals("EXIT")) {
                break;
            }
        }
        sc.close();
    }
}

