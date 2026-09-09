package com.tns.assignment7;

public class AirIndia implements Airfare {

    private double amount;

    public AirIndia() {
    }

    public AirIndia(double amount) {
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
        return amount;
    }
}