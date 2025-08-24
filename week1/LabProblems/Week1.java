import java.util.*;

public class Week1 {
    public static int count(String s) {
        return s.length();
    }

    public void splitWords(String s) {
        String[] words = s.split("\\s+");
        System.out.println("Words in the string:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println("The no. of Char in the string '" + s + "' is : " + count(s) + " using count(s)");
        System.out.print("The no. of Char in the string '" + s + "' is : " + s.length() + " using length() method");
    }
}
