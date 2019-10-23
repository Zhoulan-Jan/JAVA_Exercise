package library_management.operation;

import library_management.book.Book;
import library_management.book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请选择要归还的书籍名：");
        Scanner sc = new Scanner(System.in);
        String bookToRet = sc.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            if (book.getTitle().equals(bookToRet)) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("归还成功！");
                }
            }
        }
        if (i > bookList.getSize()) {  //都是 >
            System.out.println("未找到该书！");
        }
    }
}
