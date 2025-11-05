package week13.assignmentProblems;

public class DeleteAllOccurrencesDLL {
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

    public void deleteAll(int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == value) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev;
            }
            curr = curr.next;
        }
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
        DeleteAllOccurrencesDLL list = new DeleteAllOccurrencesDLL();
        list.insert(10); list.insert(20); list.insert(30); list.insert(20); list.insert(40);
        System.out.println("Before deletion:");
        list.display();
        list.deleteAll(20);
        System.out.println("After deletion:");
        list.display();
    }
}
