package library_management.book;

public class Book {
    private String title;
    private String num;
    private String author;
    private String type;
    private boolean isBorrowed;

    public Book(String title, String num, String author, String type, boolean isBorrowed) {
        this.title = title;
        this.num = num;
        this.author = author;
        this.type = type;
        this.isBorrowed = isBorrowed;
    }
}
