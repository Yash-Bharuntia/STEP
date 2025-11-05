package Week9.PraticeProblem;

// File: Registration.java
class ContactInfo implements Cloneable {
    String email, phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    @Override
    public String toString() {
        return "[Email: " + email + ", Phone: " + phone + "]";
    }
}

class Student implements Cloneable {
    String id, name;
    ContactInfo contact;

    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    // Shallow Copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep Copy
    public Student deepClone() throws CloneNotSupportedException {
        Student s = (Student) super.clone();
        s.contact = (ContactInfo) contact.clone();
        return s;
    }

    @Override
    public String toString() {
        return "Student: " + id + ", " + name + ", " + contact;
    }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo c1 = new ContactInfo("abc@gmail.com", "9999999999");
        Student s1 = new Student("S101", "John", c1);

        Student shallow = (Student) s1.clone();
        Student deep = s1.deepClone();

        c1.phone = "8888888888"; // modify original

        System.out.println("Original: " + s1);
        System.out.println("Shallow Copy: " + shallow);
        System.out.println("Deep Copy: " + deep);
    }
}
