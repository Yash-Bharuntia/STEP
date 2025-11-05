package Week11.PraticeProblems;

import java.util.*;

public class CustomerServiceCounter {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Command (ARRIVE <name>/SERVE/STATUS/EXIT): ");
            String cmd = sc.next();

            if (cmd.equals("ARRIVE")) {
                String name = sc.next();
                queue.add(name); // add customer to queue
            } else if (cmd.equals("SERVE")) {
                if (!queue.isEmpty()) {
                    System.out.println("Serving " + queue.poll());
                } else {
                    System.out.println("No customers waiting!");
                }
            } else if (cmd.equals("STATUS")) {
                System.out.println("Waiting: " + queue);
            } else if (cmd.equals("EXIT")) {
                break;
            }
        }
        sc.close();
    }
}
