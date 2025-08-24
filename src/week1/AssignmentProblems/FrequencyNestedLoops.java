package week1.AssignmentProblems;

import java.util.Scanner;

public class FrequencyNestedLoops {

    public static String[] findCharFrequency(String str) {
        char[] chars = str.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            if (chars[i] == '0') continue;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') count++;
        }

        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " -> " + freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[] frequencies = findCharFrequency(input);

        System.out.println("Character Frequencies:");
        System.out.println("-----------------------");
        for (String entry : frequencies) {
            System.out.println(entry);
        }
    }
}
