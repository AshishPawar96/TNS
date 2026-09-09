package com.tns.assignment3; 
 
public class TicketBooking { 
 
    private String stageEvent; 
    private String customer; 
    private Integer noOfSeats; 
 
    // Default constructor 
    public TicketBooking() { 
        stageEvent = null; 
        customer = null; 
        noOfSeats = 0; 
    } 
 
    // Parameterized constructor 
    public TicketBooking(String stageEvent, String customer, Integer noOfSeats) { 
        this.stageEvent = stageEvent; 
        this.customer = customer; 
        this.noOfSeats = noOfSeats; 
    } 
 
    // Getters and Setters 
 
    public String getStageEvent() { 
        return stageEvent; 
    } 
 
    public void setStageEvent(String stageEvent) { 
        this.stageEvent = stageEvent; 
    } 
 
    public String getCustomer() { 
        return customer; 
    } 
 
    public void setCustomer(String customer) { 
        this.customer = customer; 
    } 
 
    public Integer getNoOfSeats() { 
        return noOfSeats; 
    } 
 
    public void setNoOfSeats(Integer noOfSeats) { 
        this.noOfSeats = noOfSeats; 
    } 
 
    // Cash Payment 
    public void makePayment(Double amount) { 
        System.out.println("Payment Mode: Cash"); 
        System.out.println("Amount: " + amount); 
        System.out.println("Transaction Successful"); 
    } 
 
    // Wallet Payment 
    public void makePayment(String walletNumber, Double amount) { 
        System.out.println("Payment Mode: Wallet"); 
        System.out.println("Wallet Number: " + walletNumber); 
        System.out.println("Amount: " + amount); 
        System.out.println("Transaction Successful"); 
    } 
 
    // Credit Card Payment 
    public void makePayment(String creditCard, String ccv, String name, Double amount) { 
        System.out.println("Payment Mode: Credit Card"); 
        System.out.println("Credit Card: " + creditCard); 
        System.out.println("CCV: " + ccv); 
        System.out.println("Card Holder Name: " + name); 
        System.out.println("Amount: " + amount); 
        System.out.println("Transaction Successful"); 
    } 
} 