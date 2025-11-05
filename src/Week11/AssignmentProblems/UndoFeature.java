package week11.assignmentProblems;
import java.util.*;

public class UndoFeature {
    public static void main(String[] args) {
        Stack<String> actions = new Stack<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Type text\n2. Undo\n3. View\n4. Exit");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    actions.push(sc.nextLine());
                    break;
                case 2:
                    if (!actions.isEmpty())
                        System.out.println("Undo: " + actions.pop());
                    else
                        System.out.println("Nothing to undo");
                    break;
                case 3:
                    System.out.println("Document: " + actions);
                    break;
                case 4:
                    return;
            }
        }
    }
}
