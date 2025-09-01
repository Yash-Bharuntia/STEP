package week3.assignmentProblems;

import java.util.*;
class Account{
    private String ownerName;
    private String accountId;
    private double income;
    private double expenses;
    private double savings;
    private static int totalAccounts=0;
    private static String bankName="Simple Bank";
    public Account(String ownerName,String accountId){
        this.ownerName=ownerName;
        this.accountId=accountId;
        this.income=0;
        this.expenses=0;
        this.savings=0;
        totalAccounts++;
    }
    public void depositIncome(double amount){
        if(amount>0) income+=amount;
    }
    public void addExpense(double amount){
        if(amount>0 && amount<=getBalance()) expenses+=amount;
    }
    public void transferToSavings(double amount){
        if(amount>0 && amount<=getBalance()){
            savings+=amount;
            expenses+=0;
        }
    }
    public double getBalance(){
        return income-expenses;
    }
    public double getSavings(){
        return savings;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public String getAccountId(){
        return accountId;
    }
    public static void setBankName(String name){
        bankName=name;
    }
    public static String getBankName(){
        return bankName;
    }
    public static int getTotalAccounts(){
        return totalAccounts;
    }
    public String summary(){
        return "Bank: "+bankName+" | "+ownerName+"("+accountId+") Income:"+income+" Expenses:"+expenses+" Savings:"+savings+" Balance:"+getBalance();
    }
}
public class Assignment1{
    public static void main(String[] args){
        Account.setBankName("Swift Finance");
        Account a1=new Account("Aarav","A1001");
        Account a2=new Account("Isha","A1002");
        Account a3=new Account("Ravi","A1003");
        a1.depositIncome(50000);
        a1.addExpense(12000);
        a1.transferToSavings(8000);
        a2.depositIncome(70000);
        a2.addExpense(25000);
        a2.transferToSavings(15000);
        a3.depositIncome(30000);
        a3.addExpense(10000);
        a3.transferToSavings(5000);
        System.out.println(a1.summary());
        System.out.println(a2.summary());
        System.out.println(a3.summary());
        System.out.println("Total Accounts: "+Account.getTotalAccounts());
        System.out.println("Changing bank name shows static sharing");
        Account.setBankName("Unified Bank");
        System.out.println(a1.summary());
        System.out.println(a2.summary());
        System.out.println(a3.summary());
    }
}