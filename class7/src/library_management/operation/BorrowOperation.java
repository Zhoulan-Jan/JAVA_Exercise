package library_management.operation;

import library_management.book.Book;
import library_management.book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的书籍名：");
        String bookToFind = sc.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i); //找到库中的第i本书
            if (book.getTitle().equals(bookToFind)) {
                if (book.isBorrowed()) {
                    System.out.println("已借阅！");
                } else {
                    book.setBorrowed(false);
                }
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("未找到该书");
        }
    }
}
