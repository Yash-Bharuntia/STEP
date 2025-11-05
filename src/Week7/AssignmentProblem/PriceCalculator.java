package Week7.AssignmentProblem;

public class HotelBookingSystem {

    static class PriceCalculator {
        private static final double BASE_RATE = 150.0; // Per night

        // 1. Standard booking
        public void calculatePrice(String roomType, int nights) {
            double total = BASE_RATE * nights;
            System.out.println("--- Standard Booking ---");
            System.out.printf("Room: %s, Nights: %d -> Total: $%.2f%n", roomType, nights, total);
        }

        // 2. Seasonal booking (OVERLOADED)
        public void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
            double total = BASE_RATE * nights * seasonalMultiplier;
            System.out.println("--- Seasonal Booking ---");
            System.out.printf("Room: %s, Nights: %d, Multiplier: %.2fx -> Total: $%.2f%n", roomType, nights, seasonalMultiplier, total);
        }

        // 3. Corporate booking (OVERLOADED)
        public void calculatePrice(String roomType, int nights, double corporateDiscount, boolean hasMealPackage) {
            double baseTotal = BASE_RATE * nights;
            double discountAmount = baseTotal * corporateDiscount;
            double mealCost = hasMealPackage ? 25.0 * nights : 0;
            double finalTotal = baseTotal - discountAmount + mealCost;

            System.out.println("--- Corporate Booking ---");
            System.out.printf("Room: %s, Nights: %d -> Base Total: $%.2f%n", roomType, nights, baseTotal);
            System.out.printf("Applied Discount: -$%.2f%n", discountAmount);
            if(hasMealPackage) System.out.printf("Meal Package: +$%.2f%n", mealCost);
            System.out.printf("Final Total: $%.2f%n", finalTotal);
        }

        // 4. Wedding package (OVERLOADED)
        public void calculatePrice(String roomType, int nights, int guestCount, double decorationFee, String cateringOption) {
            double roomTotal = BASE_RATE * nights * 5; // Assuming 5 rooms for a wedding
            double cateringTotal = guestCount * (cateringOption.equals("Premium") ? 100.0 : 60.0);
            double finalTotal = roomTotal + decorationFee + cateringTotal;

            System.out.println("--- Wedding Package ---");
            System.out.printf("Rooms: %s x5, Nights: %d -> Room Total: $%.2f%n", roomType, nights, roomTotal);
            System.out.printf("Catering for %d guests (%s): $%.2f%n", guestCount, cateringOption, cateringTotal);
            System.out.printf("Decoration Fee: $%.2f%n", decorationFee);
            System.out.printf("Grand Total: $%.2f%n", finalTotal);
        }
    }

    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        calculator.calculatePrice("Queen", 3);
        System.out.println();
        calculator.calculatePrice("King", 5, 1.25); // Peak season
        System.out.println();
        calculator.calculatePrice("Suite", 4, 0.15, true); // 15% discount
        System.out.println();
        calculator.calculatePrice("Deluxe", 2, 150, 500.0, "Premium");
    }
}
