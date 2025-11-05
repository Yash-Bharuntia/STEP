package week11.assignmentProblems;

public class CircularQueue {
    private int[] queue;
    private int front, rear, size, count;

    public CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = rear = count = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        queue[rear] = item;
        rear = (rear + 1) % size;
        count++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Dequeued: " + queue[front]);
        front = (front + 1) % size;
        count--;
    }

    public boolean isFull() { return count == size; }
    public boolean isEmpty() { return count == 0; }

    public void display() {
        if (isEmpty()) { System.out.println("Queue is Empty"); return; }
        System.out.print("Queue: ");
        for (int i = 0; i < count; i++)
            System.out.print(queue[(front + i) % size] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(10); q.enqueue(20); q.enqueue(30); q.enqueue(40);
        q.display(); q.dequeue(); q.enqueue(50); q.display();
    }
}
