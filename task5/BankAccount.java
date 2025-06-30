package task5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static int accountCounter = 1000;
    private String accountHolder;
    private String accountNumber;
    private String password;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountHolder, String password, double initialBalance) {
        this.accountHolder = accountHolder;
        this.password = password;
        this.accountNumber = generateAccountNumber();
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add(LocalDateTime.now() + " - Account created with balance: ₹" + initialBalance);
    }

    private String generateAccountNumber() {
        return "ACC" + (++accountCounter);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean login(String password) {
        return this.password.equals(password);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(LocalDateTime.now() + " - Deposited: ₹" + amount);
            System.out.println("Deposited ₹" + amount + " successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(LocalDateTime.now() + " - Withdrew: ₹" + amount);
            System.out.println("Withdrew ₹" + amount + " successfully.");
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public void printAccountDetails() {
        System.out.println("\nAccount Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}
