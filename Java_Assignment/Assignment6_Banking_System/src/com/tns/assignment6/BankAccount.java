package com.tns.assignment6;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " deposited ₹" + amount);
        System.out.println("Current Balance: ₹" + balance);
    }

    public synchronized void withdraw(int amount) {

        if (balance >= amount) {
            balance -= amount;

            System.out.println(Thread.currentThread().getName()
                    + " withdrew ₹" + amount);

            System.out.println("Current Balance: ₹" + balance);
        } else {

            System.out.println(Thread.currentThread().getName()
                    + " - Insufficient Balance");
        }
    }
}