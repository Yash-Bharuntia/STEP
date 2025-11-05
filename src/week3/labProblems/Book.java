package Week3.LabProblems;
class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private static int totalBooks = 0;
    private static int availableBooks = 0;
    private static int counter = 1;

    public Book(String title, String author) {
        this.bookId = "B" + String.format("%03d", counter++);
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
        }
    }

    public void displayBookInfo() {
        System.out.println(bookId + " " + title + " by " + author + " Available: " + isAvailable);
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

class Member {
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;
    private static int counter = 1;

    public Member(String name) {
        this.memberId = "M" + String.format("%03d", counter++);
        this.memberName = name;
        this.booksIssued = new String[5];
        this.bookCount = 0;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable() && bookCount < 5 && book.issueBook()) {
            booksIssued[bookCount++] = book.getBookId();
        }
    }

    public void returnBook(String bookId, Book[] books) {
        for (int i = 0; i < bookCount; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book b : books) {
                    if (b.getBookId().equals(bookId)) {
                        b.returnBook();
                        break;
                    }
                }
                booksIssued[i] = booksIssued[--bookCount];
                break;
            }
        }
    }

    public void displayMemberInfo() {
        System.out.print(memberId + " " + memberName + " Books: ");
        for (int i = 0; i < bookCount; i++) System.out.print(booksIssued[i] + " ");
        System.out.println();
    }
}

public class LibraryMain {
    public static void main(String[] args) {
        Book[] books = {new Book("Java", "Author1"), new Book("C++", "Author2")};
        Member m1 = new Member("Alice");
        m1.borrowBook(books[0]);
        m1.displayMemberInfo();
        books[0].displayBookInfo();
        m1.returnBook(books[0].getBookId(), books);
        m1.displayMemberInfo();
        books[0].displayBookInfo();
    }
}
