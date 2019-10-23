package library_management.operation;

import library_management.book.Book;
import library_management.book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要增加的书籍名：");
        String newTitle = sc.next();
        System.out.println("要增加的书籍编号：");
        String newNum = sc.next();
        System.out.println("要增加的书籍作者：");
        String newAuthor = sc.next();
        System.out.println("要增加的书籍类型：");
        String newType = sc.next();
        Book newBook = new Book(newTitle, newNum, newAuthor, newType, false);
        //在书库里增加新书籍，注意书库的书总量+1
        bookList.setBook(bookList.getSize(), newBook);
        bookList.setSize(bookList.getSize() + 1);
    }
}
