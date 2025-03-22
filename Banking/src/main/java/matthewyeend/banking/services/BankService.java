/*
 * Author:  Matthew Yeend
 * Project: Banking
 * File:    BankService
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.banking.services;

import matthewyeend.banking.models.Account;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author matthewyeend
 */
public class BankService {
    private List<Account> accounts = new ArrayList<>();

    // Creates a new account
    public void createAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created: " + account);
    }

    // Displays all accounts
    public void displayAccounts() {
        System.out.println("\nBank Accounts:");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}
