package week11.assignmentProblems;

public class QueueUsingArray {
    private int[] queue;
    private int front, rear, size;

    public QueueUsingArray(int capacity) {
        queue = new int[capacity];
        front = rear = -1;
        size = capacity;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        if (front == -1) front = 0;
        queue[++rear] = item;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Dequeued: " + queue[front]);
        if (front >= rear) front = rear = -1;
        else front++;
    }

    public boolean isFull() { return rear == size - 1; }
    public boolean isEmpty() { return front == -1; }

    public void peek() {
        if (!isEmpty()) System.out.println("Front Element: " + queue[front]);
        else System.out.println("Queue is Empty");
    }

    public void display() {
        if (isEmpty()) { System.out.println("Queue is Empty"); return; }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        q.display();
        q.dequeue(); q.peek(); q.display();
    }
}
