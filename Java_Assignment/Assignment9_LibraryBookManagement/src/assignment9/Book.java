package assignment9;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String publication;
    private double price;
    private int copiesAvailable;

    // Constructor
    public Book(String title, String author, String isbn,
                String publication, double price, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publication = publication;
        this.price = price;
        this.copiesAvailable = copiesAvailable;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublication() {
        return publication;
    }

    public double getPrice() {
        return price;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    // Setter
    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    @Override
    public String toString() {
        return "Title : " + title +
               "\nAuthor : " + author +
               "\nISBN : " + isbn +
               "\nPublication : " + publication +
               "\nPrice : " + price +
               "\nCopies Available : " + copiesAvailable;
    }
}