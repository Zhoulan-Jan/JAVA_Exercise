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
        for (int i = 0; i < BookList.getSize();)
    }
}
