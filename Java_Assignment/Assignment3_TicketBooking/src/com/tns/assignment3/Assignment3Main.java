package com.tns.assignment3; 
 
public class Assignment3Main { 
 
    public static void main(String[] args) { 
 
        // Creating object using parameterized constructor 
        TicketBooking ticket = new TicketBooking( 
                "Drama Night", 
                "Vaishnavi", 
                3 
        ); 
 
        // Display ticket details 
        System.out.println("----- Ticket Details -----"); 
        System.out.println("Stage Event: " + ticket.getStageEvent()); 
        System.out.println("Customer: " + ticket.getCustomer()); 
        System.out.println("Number of Seats: " + ticket.getNoOfSeats()); 
 
        System.out.println(); 
 
        // Cash payment 
        ticket.makePayment(1500.0); 
 
        System.out.println(); 
 
        // Wallet payment 
        ticket.makePayment("9876543210", 1500.0); 
 
        System.out.println(); 
 
        // Credit card payment 
        ticket.makePayment( 
                "1234567890123456", 
                "123", 
                "Vaishnavi", 
                1500.0 
        ); 
    } 
} 