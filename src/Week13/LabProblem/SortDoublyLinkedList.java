package week13.labProblems;

public class SortDoublyLinkedList {
    Node head;

    class Node {
        int data;
        Node prev, next;
        Node(int d) { data = d; }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void bubbleSort() {
        boolean swapped;
        if (head == null) return;
        do {
            swapped = false;
            Node curr = head;
            while (curr.next != null) {
                if (curr.data > curr.next.data) {
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" ⇄ ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortDoublyLinkedList list = new SortDoublyLinkedList();
        list.insert(40); list.insert(10); list.insert(30); list.insert(20);
        System.out.print("Before: "); list.display();
        list.bubbleSort();
        System.out.print("After: "); list.display();
    }
}
