package assignment9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n===== Library Book Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Book");
            System.out.println("3. Update Copies");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {

                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.print("Enter Publication: ");
                    String publication = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Copies Available: ");
                    int copies = sc.nextInt();
                    sc.nextLine();

                    Book book = new Book(title, author, isbn, publication, price, copies);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter ISBN to search: ");
                    isbn = sc.nextLine();
                    library.displayBook(isbn);
                    break;

                case 3:
                    System.out.print("Enter ISBN: ");
                    isbn = sc.nextLine();

                    System.out.print("Enter New Number of Copies: ");
                    copies = sc.nextInt();
                    sc.nextLine();

                    library.updateCopies(isbn, copies);
                    break;

                case 4:
                    library.displayAllBooks();
                    break;

                case 5:
                    System.out.println("Thank you for using Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter the correct data type.");
                sc.nextLine(); // clear invalid input
                choice = 0;
            }

        } while (choice != 5);

        sc.close();
    }
}