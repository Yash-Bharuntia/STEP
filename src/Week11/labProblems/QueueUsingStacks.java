package week11.labProblems;
import java.util.*;

class QueueTwoStacks {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int x) { s1.push(x); }
    public int dequeue() {
        if (s2.isEmpty()) while (!s1.isEmpty()) s2.push(s1.pop());
        if (s2.isEmpty()) throw new NoSuchElementException("Queue is empty");
        return s2.pop();
    }
    public void display() {
        List<Integer> list = new ArrayList<>();
        list.addAll(s2);
        Collections.reverse(list);
        list.addAll(s1);
        System.out.println("Queue: " + list);
    }
}

public class QueueUsingStacks {
    public static void main(String[] args) {
        QueueTwoStacks q = new QueueTwoStacks();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        q.display();
    }
}
