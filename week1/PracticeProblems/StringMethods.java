import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();

        System.out.print("Describe your programming experience: ");
        String experience = scanner.nextLine();
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : "";
        int charCount = experience.replace(" ", "").length();

        String langUpper = language.toUpperCase();
        System.out.println("\n--- Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Language (Uppercase): " + langUpper);
        System.out.println("Experience Character Count (no spaces): " + charCount);

        scanner.close();
    }
}
