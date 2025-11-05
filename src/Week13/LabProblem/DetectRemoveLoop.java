package week13.labProblems;

public class DetectRemoveLoop {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }

    void createLoop() {
        head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        head.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n3;
    }

    boolean detectAndRemoveLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(slow);
                return true;
            }
        }
        return false;
    }

    void removeLoop(Node loopNode) {
        Node ptr1 = head;
        while (true) {
            Node ptr2 = loopNode;
            while (ptr2.next != loopNode && ptr2.next != ptr1)
                ptr2 = ptr2.next;
            if (ptr2.next == ptr1) {
                ptr2.next = null;
                return;
            }
            ptr1 = ptr1.next;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DetectRemoveLoop list = new DetectRemoveLoop();
        list.createLoop();
        if (list.detectAndRemoveLoop())
            System.out.println("Loop detected and removed.");
        else
            System.out.println("No loop found.");
        list.display();
    }
}
