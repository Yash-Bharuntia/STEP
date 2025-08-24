package week1.LabProblems;

import java.util.Scanner;

public class WordLength2DArray {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); 
                count++;
            }
        } catch (Exception e) {

        }
        return count;
    }

    public static String[] splitWords(String text) {
        text = text + " "; 
        String[] temp = new String[100];
        int wordCount = 0;
        String word = "";

        for (int i = 0; i < getLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.equals("")) {
                    temp[wordCount] = word;
                    wordCount++;
                    word = "";
                }
            }
        }
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = temp[i];
        }
        return words;
    }
    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));}
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[][] wordLengthArray = getWordLengthArray(words);
        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (int i = 0; i < wordLengthArray.length; i++) {
            String word = wordLengthArray[i][0];
            int length = Integer.parseInt(wordLengthArray[i][1]);            System.out.println(word + "\t" + length);
        }
    }
}
