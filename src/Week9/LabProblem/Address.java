package Week9.LabProblem;

class Address {
    String city;
    Address(String city) {
        this.city = city;
    }
}
class Person implements Cloneable {
    String name;
    Address address;
    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    public Person shallowClone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
    public Person deepClone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.address = new Address(address.city);
        return p;
    }
}
public class Main4 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Chennai");
        Person p1 = new Person("John", addr);
        Person shallow = p1.shallowClone();
        Person deep = p1.deepClone();
        shallow.address.city = "Delhi";
        deep.address.city = "Mumbai";
        System.out.println("Original: " + p1.address.city);
        System.out.println("Shallow Clone: " + shallow.address.city);
        System.out.println("Deep Clone: " + deep.address.city);
    }
}