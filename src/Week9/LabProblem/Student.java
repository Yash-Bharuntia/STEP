package Week9.LabProblem;

import java.util.*;
class Student {
    int id;
    String name;
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Student s = (Student) obj;
        return id == s.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "Student[ID=" + id + ", Name=" + name + "]";
    }
}
public class Main3 {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student(1, "Alice"));
        set.add(new Student(2, "Bob"));
        set.add(new Student(1, "Alice"));
        for (Student s : set)
            System.out.println(s);
    }
}