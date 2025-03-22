/*
 * Author:  Matthew Yeend
 * Project: Banking
 * File:    Banking (main)
 * Version: v1.1.1
 * Date:    22/03/2025
 */

package matthewyeend.banking;

import matthewyeend.banking.models.Account;
import matthewyeend.banking.services.BankService;

/**
 *
 * @author matthewyeend
 */
public class Banking {

    public static void main(String[] args) {
        // Creating bank service
        BankService bank = new BankService();

        // Creating an account
        Account acc1 = new Account("Alice", 500.0);
        bank.createAccount(acc1);

        // Depositing money
        acc1.deposit(200.0);

        // Displaying accounts
        bank.displayAccounts();
    }
}
