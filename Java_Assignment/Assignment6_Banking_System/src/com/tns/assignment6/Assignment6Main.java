package com.tns.assignment6;

public class Assignment6Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        DepositThread t1 = new DepositThread(account, 500);
        WithdrawThread t2 = new WithdrawThread(account, 700);
        WithdrawThread t3 = new WithdrawThread(account, 1000);

        t1.setName("Customer 1");
        t2.setName("Customer 2");
        t3.setName("Customer 3");

        t1.start();
        t2.start();
        t3.start();
    }
}