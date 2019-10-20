package library_management.operation;

import library_management.book.Book;
import library_management.book.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要查找的书名：");
        Scanner sc = new Scanner(System.in);
        String BookTitle = sc.next();
        int cntBook = 0;
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);   //已入库的书籍
            if (book.getTitle().equals(BookTitle)) { //已入库的书籍跟待查找的书籍
                System.out.println(book);  //toString要在哪里写
                cntBook++;
            }
        }
        if (cntBook == 0) {
            System.out.println("没找到此书");
        } else {
            System.out.println("共计找到：" + cntBook + " 本");
        }
    }

}
