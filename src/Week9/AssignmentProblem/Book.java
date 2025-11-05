package Week9.AssignmentProblem;

import java.util.*;
class Book implements Cloneable {
    String title;
    Book(String title) {
        this.title = title;
    }
    public Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }
}
class Library implements Cloneable {
    List<Book> books;
    Library(List<Book> books) {
        this.books = books;
    }
    public Library shallowClone() throws CloneNotSupportedException {
        return (Library) super.clone();
    }
    public Library deepClone() throws CloneNotSupportedException {
        Library copy = (Library) super.clone();
        copy.books = new ArrayList<>();
        for (Book b : books)
            copy.books.add(b.clone());
        return copy;
    }
}
public class Main4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Java"));
        list.add(new Book("Python"));
        Library lib1 = new Library(list);
        Library shallow = lib1.shallowClone();
        Library deep = lib1.deepClone();
        shallow.books.get(0).title = "C++";
        deep.books.get(1).title = "C#";
        System.out.println("Original: " + lib1.books.get(0).title + ", " + lib1.books.get(1).title);
        System.out.println("Shallow: " + shallow.books.get(0).title + ", " + shallow.books.get(1).title);
        System.out.println("Deep: " + deep.books.get(0).title + ", " + deep.books.get(1).title);
    }
}