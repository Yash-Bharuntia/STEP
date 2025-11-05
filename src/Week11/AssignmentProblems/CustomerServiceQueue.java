package week11.assignmentProblems;
import java.util.*;

public class CustomerServiceQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add customer\n2. Serve\n3. View\n4. Exit");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.print("Enter name: ");
                    queue.add(sc.nextLine());
                    break;
                case 2:
                    if (!queue.isEmpty())
                        System.out.println("Served: " + queue.poll());
                    else
                        System.out.println("No customers");
                    break;
                case 3:
                    System.out.println("Queue: " + queue);
                    break;
                case 4:
                    return;
            }
        }
    }
}
