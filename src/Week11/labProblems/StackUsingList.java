package week11.labProblems;
import java.util.*;

class MyStack {
    private List<Integer> list = new ArrayList<>();
    public void push(int x) { list.add(x); }
    public int pop() { if (isEmpty()) throw new EmptyStackException(); return list.remove(list.size()-1); }
    public int peek() { return list.get(list.size()-1); }
    public boolean isEmpty() { return list.isEmpty(); }
    public void display() { System.out.println("Stack: " + list); }
}

public class StackUsingList {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10); s.push(20); s.push(30);
        s.display();
        System.out.println("Popped: " + s.pop());
        System.out.println("Top: " + s.peek());
        System.out.println("Is empty? " + s.isEmpty());
    }
}
