package com.tns.assignment7;

public class KingFisher implements Airfare {

    private double amount;

    public KingFisher() {
    }

    public KingFisher(double amount) {
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
        return amount * 4;
    }
}