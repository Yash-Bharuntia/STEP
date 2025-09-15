import java.time.LocalDateTime;
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

    private Product(String productId, String name, String category, String manufacturer,
                    double basePrice, double weight, String[] features, Map<String,String> specifications) {
        this.productId = Objects.requireNonNull(productId);
        this.name = Objects.requireNonNull(name);
        this.category = Objects.requireNonNull(category);
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
        this.weight = weight;
        this.features = Arrays.copyOf(features, features.length);
        this.specifications = new HashMap<>(specifications);
    }

    public static Product createElectronics(String id, String name, double price, double weight, Map<String,String> specs) {
        return new Product(id, name, "Electronics", "GenericCo", price, weight, new String[] {"Electronics"}, specs);
    }

    public static Product createClothing(String id, String name, double price, double weight, Map<String,String> specs) {
        return new Product(id, name, "Clothing", "FashionInc", price, weight, new String[] {"Clothing"}, specs);
    }

    public static Product createBooks(String id, String name, double price, double weight, Map<String,String> specs) {
        return new Product(id, name, "Books", "Publisher", price, weight, new String[] {"Book"}, specs);
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return Arrays.copyOf(features, features.length); }
    public Map<String,String> getSpecifications() { return new HashMap<>(specifications); }

    public final double calculateTax(String region) {
        if ("IN".equals(region)) return basePrice * 0.18;
        if ("US".equals(region)) return basePrice * 0.07;
        return basePrice * 0.1;
    }

    @Override
    public String toString() {
        return productId + " - " + name + " (" + category + ") $" + basePrice;
    }
}

class Customer {
    private final String customerId;
    private final String email;
    private String name;
    private String phoneNumber;
    private String preferredLanguage;
    private final String accountCreationDate;
    Integer creditRating; // package-private for internal ops

    public Customer(String customerId, String email, String name, String phoneNumber, String preferredLanguage) {
        this.customerId = Objects.requireNonNull(customerId);
        this.email = Objects.requireNonNull(email);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.preferredLanguage = preferredLanguage;
        this.accountCreationDate = LocalDateTime.now().toString();
        this.creditRating = 650; // default
    }

    String getCreditRating() { return creditRating.toString(); } // package-private
    public String getPublicProfile() { return name + " (" + email + ")"; }

    public void setPhoneNumber(String phone) { if (phone != null) this.phoneNumber = phone; }
    public void setPreferredLanguage(String lang) { this.preferredLanguage = lang; }

    @Override
    public String toString() { return "Customer:" + customerId + " " + name; }
}

class ShoppingCart {
    private final String cartId;
    private final String customerId;
    private final List<Item> items = new ArrayList<>();
    private double totalAmount = 0.0;
    private int itemCount = 0;

    private static class Item { Product product; int quantity; Item(Product p,int q){product=p;quantity=q;} }

    public ShoppingCart(String cartId, String customerId) {
        this.cartId = cartId; this.customerId = customerId;
    }

    public boolean addItem(Object product, int quantity) {
        if (!(product instanceof Product) || quantity <= 0) return false;
        Product p = (Product) product;
        items.add(new Item(p, quantity));
        totalAmount += p.getBasePrice() * quantity;
        itemCount += quantity;
        return true;
    }

    private double calculateDiscount() {
        return totalAmount > 1000 ? totalAmount * 0.05 : 0.0;
    }

    String getCartSummary() { // package-private
        return "Cart:" + cartId + " items=" + itemCount + " total=" + (totalAmount - calculateDiscount());
    }

    public double checkout() {
        double discount = calculateDiscount();
        return totalAmount - discount;
    }
}

class Order {
    private final String orderId;
    private final LocalDateTime orderTime;
    private final String customerId;
    private final List<Product> products;

    public Order(String orderId, String customerId, List<Product> products) {
        this.orderId = orderId;
        this.orderTime = LocalDateTime.now();
        this.customerId = customerId;
        this.products = new ArrayList<>(products);
    }

    public String getOrderId() { return orderId; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public String getCustomerId() { return customerId; }
    public List<Product> getProducts() { return new ArrayList<>(products); }
}

class PaymentProcessor {
    private final String processorId;
    private final String securityKey;

    public PaymentProcessor(String processorId, String securityKey) {
        this.processorId = processorId;
        this.securityKey = securityKey;
    }

    public boolean processPayment(double amount) {
        return amount > 0;
    }
}

class ShippingCalculator {
    private final Map<String, Double> shippingRates;
    public ShippingCalculator(Map<String, Double> rates) { this.shippingRates = new HashMap<>(rates); }
    public double calculate(String region, double weight) { return shippingRates.getOrDefault(region, 50.0) * Math.ceil(weight); }
}

final class ECommerceSystem {
    private static final Map<String, Product> productCatalog = new HashMap<>();

    public static boolean processOrder(Order order, Customer customer) {
        return order != null && customer != null;
    }

    public static void main(String[] args) {
        Product p1 = Product.createElectronics("P100","Smartphone", 300, 0.4, Map.of("RAM","8GB"));
        Product p2 = Product.createBooks("P200","Java Basics", 40, 0.8, Map.of("Pages","350"));
        productCatalog.put(p1.getProductId(), p1);
        productCatalog.put(p2.getProductId(), p2);

        Customer customer = new Customer("C001","alice@example.com","Alice","9999999999","EN");
        ShoppingCart cart = new ShoppingCart("CART1", customer.getPublicProfile());
        cart.addItem(p1, 1);
        cart.addItem(p2, 2);

        System.out.println(cart.getCartSummary());
        double payable = cart.checkout();
        System.out.println("Payable: " + payable);

        Order order = new Order("O100", customer.getPublicProfile(), List.of(p1,p2));
        PaymentProcessor pp = new PaymentProcessor("PP1","key123");
        boolean paid = pp.processPayment(payable);
        System.out.println("Payment success: " + paid);
    }
}