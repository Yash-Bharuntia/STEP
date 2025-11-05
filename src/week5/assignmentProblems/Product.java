package Week5.AssignmentProblems;

import java.util.*;
final class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;
    private Product(String productId, String name, String category, String manufacturer, double basePrice, double weight, String[] features, Map<String, String> specifications) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
        this.weight = weight;
        this.features = Arrays.copyOf(features, features.length);
        this.specifications = new HashMap<>(specifications);
    }
    public static Product createElectronics(String productId, String name, String manufacturer, double price, double weight, String[] features, Map<String, String> specifications) {
        return new Product(productId, name, "Electronics", manufacturer, price, weight, features, specifications);
    }
    public static Product createClothing(String productId, String name, String manufacturer, double price, double weight, String[] features, Map<String, String> specifications) {
        return new Product(productId, name, "Clothing", manufacturer, price, weight, features, specifications);
    }
    public static Product createBooks(String productId, String name, String manufacturer, double price, double weight, String[] features, Map<String, String> specifications) {
        return new Product(productId, name, "Books", manufacturer, price, weight, features, specifications);
    }
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return Arrays.copyOf(features, features.length); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }
    public final double calculateTax(String region) {
        if(region.equalsIgnoreCase("US")) return basePrice * 0.07;
        if(region.equalsIgnoreCase("EU")) return basePrice * 0.21;
        return basePrice * 0.10;
    }
}
class Customer {
    private final String customerId;
    private final String email;
    private String name;
    private String phoneNumber;
    private String preferredLanguage;
    private final String accountCreationDate;
    Customer(String customerId, String email, String accountCreationDate) {
        this.customerId = customerId;
        this.email = email;
        this.accountCreationDate = accountCreationDate;
    }
    public String getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public String getAccountCreationDate() { return accountCreationDate; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getPreferredLanguage() { return preferredLanguage; }
    void setName(String name) { this.name = name; }
    void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    void setPreferredLanguage(String language) { this.preferredLanguage = language; }
    String getCreditRating() { return "A"; }
    public String getPublicProfile() {
        return name + ", " + preferredLanguage;
    }
}
class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private final List<Object> items = new ArrayList<>();
    private double totalAmount;
    private int itemCount;
    ShoppingCart(String cartId, String customerId) {
        this.cartId = cartId;
        this.customerId = customerId;
    }
    public String getCartId() { return cartId; }
    public String getCustomerId() { return customerId; }
    public List<Object> getItems() { return new ArrayList<>(items); }
    public double getTotalAmount() { return totalAmount; }
    public int getItemCount() { return itemCount; }
    public boolean addItem(Object product, int quantity) {
        if(product instanceof Product) {
            for(int i=0; i<quantity; i++) items.add(product);
            itemCount += quantity;
            totalAmount += ((Product)product).getBasePrice() * quantity;
            return true;
        }
        return false;
    }
    double calculateDiscount() { return totalAmount > 1000 ? totalAmount * 0.05 : 0; }
    String getCartSummary() { return "Items: " + itemCount + ", Total: " + totalAmount; }
}
final class Order {
    private final String orderId;
    private final java.time.LocalDateTime orderTime;
    Order(String orderId, java.time.LocalDateTime orderTime) {
        this.orderId = orderId;
        this.orderTime = orderTime;
    }
    public String getOrderId() { return orderId; }
    public java.time.LocalDateTime getOrderTime() { return orderTime; }
}
class PaymentProcessor {
    private final String processorId;
    private final String securityKey;
    PaymentProcessor(String processorId, String securityKey) {
        this.processorId = processorId;
        this.securityKey = securityKey;
    }
    public String getProcessorId() { return processorId; }
    public String getSecurityKey() { return securityKey; }
}
class ShippingCalculator {
    private final Map<String, Double> shippingRates;
    ShippingCalculator(Map<String, Double> shippingRates) {
        this.shippingRates = new HashMap<>(shippingRates);
    }
    public Map<String, Double> getShippingRates() { return new HashMap<>(shippingRates); }
}
final class ECommerceSystem {
    private static final Map<String, Object> productCatalog = new HashMap<>();
    public static boolean processOrder(Object order, Object customer) {
        if(order instanceof Order && customer instanceof Customer) {
            return true;
        }
        return false;
    }
    public static void inventoryManagement() {}
    public static void orderFulfillment() {}
}