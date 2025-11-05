package week13.assignmentProblems;

public class CircularTaskManager {
    Node tail;

    class Node {
        String task;
        int time;
        Node next;
        Node(String t, int time) { this.task = t; this.time = time; }
    }

    public void addTask(String name, int time) {
        Node newNode = new Node(name, time);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void executeTasks() {
        if (tail == null) return;
        Node current = tail.next;
        System.out.print("Execution order → ");
        while (tail != null) {
            current.time--;
            System.out.print(current.task + " ");
            if (current.time == 0) {
                if (current == tail && current.next == tail) {
                    tail = null;
                    break;
                }
                removeTask(current);
            }
            current = (current.next != null) ? current.next : tail.next;
        }
        System.out.println("(All Completed)");
    }

    private void removeTask(Node taskNode) {
        Node temp = tail;
        while (temp.next != taskNode) temp = temp.next;
        temp.next = taskNode.next;
        if (taskNode == tail) tail = temp;
    }

    public static void main(String[] args) {
        CircularTaskManager tm = new CircularTaskManager();
        tm.addTask("T1", 3);
        tm.addTask("T2", 2);
        tm.addTask("T3", 4);
        tm.executeTasks();
    }
}
