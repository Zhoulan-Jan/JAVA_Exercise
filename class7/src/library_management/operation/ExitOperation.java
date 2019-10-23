package library_management.operation;

import library_management.book.BookList;

public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("goodbye!");
        System.exit(0);
    }
}
