package Week3.AssignmentProblem;

import java.util.*;

class Product {
    private String productId, productName, category;
    private double price;
    private int stockQuantity;
    private static int counter = 1;

    public Product(String name, double price, String category, int stock) {
        this.productId = "P" + String.format("%03d", counter++);
        this.productName = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stock;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public boolean reduceStock(int q) { if (q > 0 && stockQuantity >= q) { stockQuantity -= q; return true; } return false; }
    public void addStock(int q) { if (q > 0) stockQuantity += q; }

    public static Product findProductById(Product[] products, String id) {
        for (Product p : products) if (p != null && p.getProductId().equals(id)) return p;
        return null;
    }

    public static Product[] getProductsByCategory(Product[] products, String cat) {
        List<Product> list = new ArrayList<>();
        for (Product p : products) if (p != null && p.getCategory().equalsIgnoreCase(cat)) list.add(p);
        return list.toArray(new Product[0]);
    }

    public String toString() { return productId + " | " + productName + " | " + category + " | " + price + " | Stock: " + stockQuantity; }
}

class ShoppingCart {
    private String cartId, customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int count;
    private static int counter = 1;

    public ShoppingCart(String customer) {
        this.cartId = "CART" + String.format("%03d", counter++);
        this.customerName = customer;
        this.products = new Product[50];
        this.quantities = new int[50];
        this.count = 0;
    }

    public void addProduct(Product product, int quantity) {
        if (product != null && quantity > 0 && product.getStockQuantity() >= quantity) {
            int idx = indexOf(product.getProductId());
            if (idx >= 0) { if (product.reduceStock(quantity)) quantities[idx] += quantity; }
            else { if (product.reduceStock(quantity)) { products[count] = product; quantities[count] = quantity; count++; } }
            calculateTotal();
        }
    }

    public void removeProduct(String productId) {
        int idx = indexOf(productId);
        if (idx >= 0) {
            products[idx].addStock(quantities[idx]);
            products[idx] = products[count - 1]; quantities[idx] = quantities[count - 1];
            products[count - 1] = null; quantities[count - 1] = 0; count--;
            calculateTotal();
        }
    }

    private int indexOf(String productId) { for (int i = 0; i < count; i++) if (products[i].getProductId().equals(productId)) return i; return -1; }

    public void calculateTotal() { double t = 0; for (int i = 0; i < count; i++) t += products[i].getPrice() * quantities[i]; cartTotal = t; }
    public void displayCart() { System.out.println("Cart: " + cartId + " | Customer: " + customerName); for (int i = 0; i < count; i++) System.out.println(products[i].getProductId() + " x " + quantities[i]); System.out.println("Total: " + cartTotal); }
    public void checkout() { System.out.println("Checkout: " + cartTotal); products = new Product[50]; quantities = new int[50]; count = 0; cartTotal = 0; }
}

public class Assignment2Main {
    public static void main(String[] args) {
        Product[] catalog = { new Product("Phone X", 69999, "Electronics", 10), new Product("Laptop Pro", 119999, "Electronics", 5), new Product("Sneakers", 3999, "Fashion", 20) };
        ShoppingCart cart = new ShoppingCart("Alice");
        cart.addProduct(catalog[0], 1); cart.addProduct(catalog[2], 2);
        cart.displayCart();
        cart.removeProduct(catalog[2].getProductId());
        cart.displayCart();
        cart.checkout();
    }
}
