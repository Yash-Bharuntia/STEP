package Week11.PraticeProblems;

import java.util.*;

public class PrintQueueSystem {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ADD <doc>/PRINT/EXIT): ");
            String cmd = sc.next();

            if (cmd.equals("ADD")) {
                String doc = sc.next();
                printQueue.add(doc); // enqueue document
            } else if (cmd.equals("PRINT")) {
                if (!printQueue.isEmpty()) {
                    System.out.println("Printing " + printQueue.poll());
                } else {
                    System.out.println("No jobs left!");
                }
            } else if (cmd.equals("EXIT")) {
                break;
            }
        }
        sc.close();
    }
}
