package task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Set Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ₹");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();
                    BankAccount newAccount = new BankAccount(name, password, initialBalance);
                    accounts.add(newAccount);
                    System.out.println("Account created. Your Account Number: " + newAccount.getAccountNumber());
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String pass = scanner.nextLine();

                    BankAccount loginAccount = null;
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(accNum) && acc.login(pass)) {
                            loginAccount = acc;
                            break;
                        }
                    }

                    if (loginAccount != null) {
                        System.out.println("Login successful!");
                        int subChoice;
                        do {
                            System.out.println("\n------ Menu ------");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Show Balance");
                            System.out.println("4. Show Transaction History");
                            System.out.println("5. Show Account Details");
                            System.out.println("0. Logout");
                            System.out.print("Choose option: ");
                            subChoice = scanner.nextInt();

                            switch (subChoice) {
                                case 1:
                                    System.out.print("Enter amount to deposit: ₹");
                                    double depositAmt = scanner.nextDouble();
                                    loginAccount.deposit(depositAmt);
                                    break;
                                case 2:
                                    System.out.print("Enter amount to withdraw: ₹");
                                    double withdrawAmt = scanner.nextDouble();
                                    loginAccount.withdraw(withdrawAmt);
                                    break;
                                case 3:
                                    System.out.println("Current Balance: ₹" + loginAccount.getBalance());
                                    break;
                                case 4:
                                    loginAccount.printTransactionHistory();
                                    break;
                                case 5:
                                    loginAccount.printAccountDetails();
                                    break;
                                case 0:
                                    System.out.println("Logged out successfully.");
                                    break;
                                default:
                                    System.out.println("Invalid choice! Try again.");
                            }
                        } while (subChoice != 0);
                    } else {
                        System.out.println("Login failed. Invalid account number or password.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
