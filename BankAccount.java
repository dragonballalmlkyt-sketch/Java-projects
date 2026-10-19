import java.util.Scanner;
public class BankAccount {
    public static void main(String[] args) {

        Bank myBank = new Bank("My Bank", 1000.0);
        if (myBank != null) {
            System.out.println("Bank created successfully: " + myBank.getBalance());

            if (myBank.deposit(500.0)) {
                System.out.println("Deposit successful. New balance: " + myBank.getBalance());
            } else {
                System.out.println("Deposit failed.");
            }

            if (myBank.withdraw(200.0)) {
                System.out.println("Withdrawal successful. New balance: " + myBank.getBalance());
            } else {
                System.out.println("Withdrawal failed.");
            }

            
        }
    
    }
    static class Bank{
        private String name;
        private double balance;

        public Bank(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        public boolean deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                return true;
            } else {
                return false;
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }

        public double getBalance() {
            return balance;
        }
    }
}