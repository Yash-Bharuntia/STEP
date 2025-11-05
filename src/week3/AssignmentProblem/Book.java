package Week3.AssignmentProblem;

import java.util.*;

class Book {
    private String bookId, title, author, isbn, category;
    private boolean isIssued;
    private String issueDate, dueDate;
    private static int counter = 1;

    public Book(String title, String author, String isbn, String category) {
        this.bookId = "B" + String.format("%03d", counter++);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }
    public void issue(String issue, String due) { isIssued = true; issueDate = issue; dueDate = due; }
    public void returned() { isIssued = false; issueDate = null; dueDate = null; }
    public String toString() { return bookId + " | " + title + " | " + author + " | " + category + " | Issued: " + isIssued; }
}

class Member {
    private String memberId, memberName, memberType;
    private List<Book> booksIssued;
    private double totalFines;
    private static int counter = 1;
    private static double finePerDay = 10;
    private static int maxBooksAllowed = 3;

    public Member(String name, String type) {
        memberId = "M" + String.format("%03d", counter++);
        memberName = name;
        memberType = type;
        booksIssued = new ArrayList<>();
    }

    public void issueBook(Book book, String issue, String due) {
        if (!book.isIssued() && booksIssued.size() < maxBooksAllowed) {
            book.issue(issue, due);
            booksIssued.add(book);
        }
    }

    public void returnBook(Book book, int overdueDays) {
        if (booksIssued.contains(book)) {
            book.returned();
            booksIssued.remove(book);
            if (overdueDays > 0) totalFines += overdueDays * finePerDay;
        }
    }

    public void displayInfo() {
        System.out.println(memberId + " | " + memberName + " | " + memberType + " | Fines: " + totalFines);
        for (Book b : booksIssued) System.out.println("   -> " + b);
    }
}

public class Assignment5Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James", "111", "Programming");
        Book b2 = new Book("DBMS", "Navathe", "222", "Database");
        Member m1 = new Member("Alice", "Student");
        m1.issueBook(b1, "2025-09-01", "2025-09-10");
        m1.issueBook(b2, "2025-09-01", "2025-09-12");
        m1.displayInfo();
        m1.returnBook(b1, 3);
        m1.displayInfo();
    }
}
