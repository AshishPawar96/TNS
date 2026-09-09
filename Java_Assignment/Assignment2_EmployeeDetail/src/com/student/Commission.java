package com.student;

import java.util.Scanner;

public class Commission {

    String name;
    String address;
    String phone;
    double salesAmount;

    void acceptDetails() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Address: ");
        address = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        phone = sc.nextLine();

        System.out.print("Enter Sales Amount: ");
        salesAmount = sc.nextDouble();
        
        sc.close();
    }

    void calculateCommission() {

        double commission;

        if (salesAmount >= 100000) {
            commission = salesAmount * 0.10;
        }
        else if (salesAmount >= 50000) {
            commission = salesAmount * 0.05;
        }
        else if (salesAmount >= 30000) {
            commission = salesAmount * 0.03;
        }
        else {
            commission = 0;
        }

        System.out.println("\nEmployee Details");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
        System.out.println("Sales Amount: " + salesAmount);
        System.out.println("Commission: " + commission);
    }

    public static void main(String[] args) {

        Commission emp = new Commission();

        emp.acceptDetails();
        emp.calculateCommission();

    }
}