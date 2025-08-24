package week1.LabProblems;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Codechef {
    public static int count(String s){
        int i = 0;
        boolean b = true;
        try{
            while(b){
                char c = s.charAt(i);
                i++;
            }
        }catch(RuntimeException e){
            b = false;
        }
        return i;
}
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("The no. of Char in the string '" + s +"' is : " + count(s) + " using count(s)");
		System.out.print("The no. of Char in the string '" + s +"' is : " + s.length() + " using length() method");

	}
}
