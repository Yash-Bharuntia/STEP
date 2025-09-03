package week3.labProblems;

class Book {
    private final String bookId;
    private final String title;
    private final String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookId = generateBookId();
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    public static String generateBookId() {
        return String.format("B%03d", totalBooks + 1);
    }

    public boolean issueBook() {
        if (!isAvailable) return false;
        isAvailable = false;
        availableBooks--;
        return true;
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public void displayBookInfo() {
        System.out.println("Book ID     : " + bookId);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Available   : " + (isAvailable ? "Yes" : "No"));
        System.out.println("---------------------------");
    }

    public String getBookId() { return bookId; }
    public boolean getAvailability() { return isAvailable; }

    public static int getTotalBooks() { return totalBooks; }
    public static int getAvailableBooks() { return availableBooks; }
}

class Member {
    private final String memberId;
    private final String memberName;
    private final String[] booksIssued;
    private int bookCount;
    private static int totalMembers = 0;

    public Member(String memberName) {
        this.memberName = memberName;
        this.memberId = generateMemberId();
        this.booksIssued = new String[5]; // Max 5 books
        this.bookCount = 0;
        totalMembers++;
    }

    public static String generateMemberId() {
        return String.format("M%03d", totalMembers + 1);
    }

    public void borrowBook(Book book) {
        if (bookCount >= booksIssued.length) {
            System.out.println(memberName + " has reached the book limit.");
            return;
        }
        if (book.issueBook()) {
            booksIssued[bookCount++] = book.getBookId();
            System.out.println(memberName + " borrowed book " + book.getBookId());
        } else {
            System.out.println("Book " + book.getBookId() + " is not available.");
        }
    }

    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book b : books) {
                    if (b.getBookId().equals(bookId)) {
                        b.returnBook();
                        System.out.println(memberName + " returned book " + bookId);
                        booksIssued[i] = booksIssued[bookCount - 1]; // Replace with last
                        booksIssued[bookCount - 1] = null;
                        bookCount--;
                        return;
                    }
                }
            }
        }
        System.out.println("Book ID " + bookId + " not found in " + memberName + "'s issued list.");
    }

    public void displayMemberInfo() {
        System.out.println("Member ID   : " + memberId);
        System.out.println("Name        : " + memberName);
        System.out.print("Books Issued: ");
        for (int i = 0; i < bookCount; i++) {
            System.out.print(booksIssued[i] + " ");
        }
        System.out.println("\n---------------------------");
    }

    public static int getTotalMembers() { return totalMembers; }
}

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("The Alchemist", "Paulo Coelho");
        books[1] = new Book("Clean Code", "Robert C. Martin");
        books[2] = new Book("Atomic Habits", "James Clear");

        Member[] members = new Member[2];
        members[0] = new Member("Yash");
        members[1] = new Member("Aarav");

        members[0].borrowBook(books[0]);
        members[0].borrowBook(books[1]);
        members[1].borrowBook(books[0]);

        members[0].returnBook("B001", books);
        members[1].borrowBook(books[0]);

        for (Book b : books) b.displayBookInfo();
        for (Member m : members) m.displayMemberInfo();

        System.out.println("Total Books     : " + Book.getTotalBooks());
        System.out.println("Available Books : " + Book.getAvailableBooks());
        System.out.println("Total Members   : " + Member.getTotalMembers());
    }
}