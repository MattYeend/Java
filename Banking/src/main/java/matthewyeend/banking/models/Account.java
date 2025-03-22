/*
 * Author:  Matthew Yeend
 * Project: Banking
 * File:    Account
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.banking.models;

/**
 *
 * @author matthewyeend
 */
public class Account {
    private String accountHolder;
    private double balance;

    // Constructor to initialize account details
    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + ". New balance: $" + balance);
    }

    // Returns account details
    @Override
    public String toString() {
        return "Account{" + "Holder='" + accountHolder + "', Balance=$" + balance + "}";
    }
}
