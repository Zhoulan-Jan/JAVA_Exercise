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

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Book{" +
                "name='" + title + '\'' +
                ", id='" + num + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
