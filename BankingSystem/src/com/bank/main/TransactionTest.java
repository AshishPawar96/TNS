package com.bank.main;

import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;

public class TransactionTest {

    public static void main(String[] args) {

        Transaction transaction = new Transaction();

        transaction.setTransactionId(2);
        transaction.setAccountId(1001);
        transaction.setTransactionType("Deposit");
        transaction.setAmount(2000);
        transaction.setTransactionDate("2026-08-14");

        TransactionDAO dao = new TransactionDAO();

        dao.addTransaction(transaction);

        System.out.println("\nTransaction History:");

        dao.viewTransactions(1001);
    }
}