package Week4.AssignmentProblem;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.isbn = "0000";
        this.isAvailable = true;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "0000";
        this.isAvailable = true;
    }

    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Available: " + isAvailable);
    }
}

public class Problem3Main {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java Basics", "James");
        Book b3 = new Book("DBMS", "Navathe", "12345", true);

        b2.borrowBook();
        b3.borrowBook();
        b2.returnBook();

        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
    }
}
