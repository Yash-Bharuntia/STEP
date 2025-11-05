package Week4.AssignmentProblem;

class FoodOrder {
    private String customerName;
    private String foodItem;
    private int quantity;
    private double price;

    public FoodOrder() {
        this.customerName = "Unknown";
        this.foodItem = "Unknown";
        this.quantity = 0;
        this.price = 0.0;
    }

    public FoodOrder(String foodItem) {
        this.customerName = "Default";
        this.foodItem = foodItem;
        this.quantity = 1;
        this.price = 100.0;
    }

    public FoodOrder(String foodItem, int quantity) {
        this.customerName = "Default";
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = quantity * 100.0;
    }

    public void printBill() {
        System.out.println("Customer: " + customerName + " | Item: " + foodItem + " | Qty: " + quantity + " | Total: " + price);
    }
}

public class Problem4Main {
    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Burger");
        FoodOrder o3 = new FoodOrder("Pizza", 3);

        o1.printBill();
        o2.printBill();
        o3.printBill();
    }
}
