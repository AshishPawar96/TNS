package assignment9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    // Add a new book
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getIsbn().equals(book.getIsbn())) {
                System.out.println("Error: Duplicate ISBN! Book already exists.");
                return;
            }
        }

        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Display a specific book using ISBN
    public void displayBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                System.out.println("\nBook Details");
                System.out.println(b);
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Update copies available
    public void updateCopies(String isbn, int copies) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                b.setCopiesAvailable(copies);
                System.out.println("Copies updated successfully.");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Display all books sorted by title
    public void displayAllBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        Collections.sort(books, Comparator.comparing(Book::getTitle));

        System.out.println("\n===== Book List =====");

        for (Book b : books) {
            System.out.println(b);
            System.out.println("----------------------------");
        }
    }
}