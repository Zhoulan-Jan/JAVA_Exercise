package library_management.operation;

import library_management.book.Book;
import library_management.book.BookList;

public class PrintAllOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            System.out.println(book);
        }
    }
}
