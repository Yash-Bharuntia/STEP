package week13.assignmentProblems;
import java.util.*;

public class InsertAtPositionSLL {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int d) { data = d; next = null; }
    }

    public void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" → ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertAtPositionSLL list = new InsertAtPositionSLL();
        list.head = list.new Node(10);
        list.head.next = list.new Node(20);
        list.head.next.next = list.new Node(30);
        list.head.next.next.next = list.new Node(40);

        System.out.println("Before insertion:");
        list.display();
        list.insertAtPosition(50, 3);
        System.out.println("After insertion:");
        list.display();
    }
}
