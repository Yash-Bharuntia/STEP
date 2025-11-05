package Week4.PraticeProblems;

class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title + " | Author: " + author + " | Price: " + price);
    }
}

public class Q1Main {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java Basics", "James", 499);
        b1.display();
        b2.display();
    }
}