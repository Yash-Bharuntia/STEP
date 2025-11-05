package Week9.AssignmentProblem;

class Product {
    int productId;
    String productName;
    Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Product p = (Product) obj;
        return productId == p.productId;
    }
}
public class Main2 {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop");
        Product p2 = new Product(1, "Laptop");
        Product p3 = p1;
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p3);
    }
}