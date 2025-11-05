package Week3.PraticeProblem;
import java.util.*;

class Book {
    String title, author, isbn;
    double price;
    int quantity;

    public Book(String title, String author, String isbn, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.quantity = quantity;
    }

    public void displayBook() {
        System.out.println(title + " by " + author + " | ISBN: " + isbn + " | Price: " + price + " | Qty: " + quantity);
    }
}

class Library {
    String libraryName;
    ArrayList<Book> books;

    public Library(String name) {
        this.libraryName = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public Book searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    public void displayInventory() {
        System.out.println("Library: " + libraryName);
        for (Book b : books) b.displayBook();
    }

    public double calculateTotalValue() {
        double sum = 0;
        for (Book b : books) sum += b.price * b.quantity;
        return sum;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library("City Library");

        lib.addBook(new Book("Java Basics", "James Gosling", "111", 250, 5));
        lib.addBook(new Book("OOP in Java", "Herbert Schildt", "222", 300, 3));

        lib.displayInventory();

        Book found = lib.searchBook("Java Basics");
        if (found != null) {
            System.out.println("Book Found:");
            found.displayBook();
        } else {
            System.out.println("Book not found.");
        }

        System.out.println("Total Value of Library: " + lib.calculateTotalValue());
    }
}
