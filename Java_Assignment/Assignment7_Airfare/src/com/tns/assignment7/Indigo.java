package com.tns.assignment7;

public class Indigo implements Airfare {

    private double amount;

    public Indigo() {
    }

    public Indigo(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateAmount() {
        return amount * 8;
    }
}