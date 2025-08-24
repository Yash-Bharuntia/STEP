package week1.AssignmentProblems;

import java.util.Scanner;

public class CharacterFrequency {
    public static String[][] findCharFrequency(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }
        String[][] result = new String[str.length()][2];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch] != 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                freq[ch] = 0; 
                index++;
            }
        }
        String[][] finalResult = new String[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }
        return finalResult;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String[][] freqArray = findCharFrequency(input);
        System.out.println("Character\tFrequency");
        System.out.println("-------------------------");
        for (String[] strings : freqArray) {
            System.out.println(strings[0] + "\t\t" + strings[1]);
        }
    }
}
