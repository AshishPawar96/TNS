package assignment4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input: StageEvent,Customer,NoOfSeats
        String bookingDetails = sc.nextLine();

        String[] details = bookingDetails.split(",");

        TicketBooking ticket = new TicketBooking(
                details[0],
                details[1],
                Integer.parseInt(details[2])
        );

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                double cashAmount = sc.nextDouble();
                ticket.makePayment(cashAmount);
                break;

            case 2:
                double walletAmount = sc.nextDouble();
                String walletNumber = sc.next();
                ticket.makePayment(walletNumber, walletAmount);
                break;

            case 3:
                sc.nextLine(); // Consume newline

                String holderName = sc.nextLine();
                double cardAmount = sc.nextDouble();
                String creditCard = sc.next();
                String ccv = sc.next();

                ticket.makePayment(
                        creditCard,
                        ccv,
                        holderName,
                        cardAmount
                );
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}