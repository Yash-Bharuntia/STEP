package week3.assignmentProblems;

import java.util.*;
class Book{
    String isbn;
    String title;
    String author;
    String publisher;
    String category;
    boolean available;
    String borrowerId;
    String dueDate;
    static int totalBooks=0;
    public Book(String isbn,String title,String author,String publisher,String category){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.publisher=publisher;
        this.category=category;
        this.available=true;
        this.borrowerId="";
        this.dueDate="";
        totalBooks++;
    }
}
class Member{
    String id;
    String name;
    String type;
    Book[] borrowed;
    double dueAmount;
    String joinDate;
    public Member(String id,String name,String type,String joinDate){
        this.id=id;
        this.name=name;
        this.type=type;
        this.joinDate=joinDate;
        this.borrowed=new Book[10];
        this.dueAmount=0;
    }
    public int maxBorrow(){
        if(type.equals("Faculty")) return 5;
        if(type.equals("Student")) return 3;
        return 2;
    }
}
class Library{
    static int totalBooks=0;
    static int totalMembers=0;
    static String rules="Return on time";
    static double finePerDay=2.0;
    static int defaultMaxBorrow=3;
    ArrayList<Book> books=new ArrayList<>();
    ArrayList<Member> members=new ArrayList<>();
    public void addBook(Book b){
        books.add(b);
        totalBooks++;
    }
    public void addMember(Member m){
        members.add(m);
        totalMembers++;
    }
    public Member findMember(String id){
        for(Member m:members) if(m.id.equals(id)) return m;
        return null;
    }
    public Book findBook(String isbn){
        for(Book b:books) if(b.isbn.equals(isbn)) return b;
        return null;
    }
    public boolean borrow(String memberId,String isbn,String dueDate){
        Member m=findMember(memberId);
        Book b=findBook(isbn);
        if(m==null || b==null || !b.available) return false;
        int count=0;
        for(Book x:m.borrowed) if(x!=null) count++;
        if(count>=m.maxBorrow()) return false;
        for(int i=0;i<m.borrowed.length;i++){
            if(m.borrowed[i]==null){
                m.borrowed[i]=b;
                b.available=false;
                b.borrowerId=memberId;
                b.dueDate=dueDate;
                return true;
            }
        }
        return false;
    }
    public boolean returns(String memberId,String isbn,int overdueDays){
        Member m=findMember(memberId);
        Book b=findBook(isbn);
        if(m==null || b==null || b.available) return false;
        for(int i=0;i<m.borrowed.length;i++){
            if(m.borrowed[i]!=null && m.borrowed[i].isbn.equals(isbn)){
                m.borrowed[i]=null;
                b.available=true;
                b.borrowerId="";
                b.dueDate="";
                if(overdueDays>0) m.dueAmount+=finePerDay*overdueDays;
                return true;
            }
        }
        return false;
    }
    public void payFine(String memberId,double amount){
        Member m=findMember(memberId);
        if(m!=null && amount>0){
            m.dueAmount=Math.max(0,m.dueAmount-amount);
        }
    }
    public void listBooks(){
        for(Book b:books) System.out.println(b.isbn+" "+b.title+" "+(b.available?"Available":"Borrowed by "+b.borrowerId));
    }
    public void listMembers(){
        for(Member m:members) System.out.println(m.id+" "+m.name+" "+m.type+" Due:"+m.dueAmount);
    }
    public static void setRules(String r){ rules=r; }
    public static void setFinePerDay(double f){ finePerDay=f; }
    public static void setMaxBorrow(int m){ defaultMaxBorrow=m; }
}
public class Assignment5{
    public static void main(String[] args){
        Library lib=new Library();
        lib.addBook(new Book("B1","DSA","Kumar","Pub1","Edu"));
        lib.addBook(new Book("B2","OOP","Sharma","Pub2","Edu"));
        lib.addBook(new Book("B3","Novel","A Author","Pub3","Fiction"));
        lib.addMember(new Member("M1","Rohit","Student","2025-01-01"));
        lib.addMember(new Member("M2","Seema","Faculty","2024-08-09"));
        lib.listBooks();
        lib.borrow("M1","B1","2025-09-10");
        lib.borrow("M1","B2","2025-09-10");
        lib.listBooks();
        lib.returns("M1","B1",3);
        lib.listMembers();
        lib.payFine("M1",5);
        lib.listMembers();
    }
}