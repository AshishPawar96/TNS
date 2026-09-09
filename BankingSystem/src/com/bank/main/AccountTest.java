package com.bank.main;

import com.bank.dao.AccountDAO;
import com.bank.model.Account;

public class AccountTest {

    public static void main(String[] args) {

        Account account = new Account();

        account.setAccountId(1002);
        account.setCustomerId(101);
        account.setAccountType("Savings");
        account.setBalance(5000);

        AccountDAO dao = new AccountDAO();

        dao.addAccount(account);

        System.out.println("\nAccount Details:");
        dao.viewAccounts();
    }
}