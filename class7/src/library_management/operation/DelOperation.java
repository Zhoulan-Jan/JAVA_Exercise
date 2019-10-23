package library_management.operation;

import library_management.book.Book;
import library_management.book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请选择要删除的书籍名字：");
        Scanner sc = new Scanner(System.in);
        String oldTitle = sc.next();
        //找到这本书
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBooks(i);
            if (oldTitle.equals(book.getTitle())) {
                //用最后一本书覆盖这本书
                Book lastBook = bookList.getBooks(bookList.getSize()-1);
                bookList.setBook(i,lastBook);
                bookList.setSize(bookList.getSize()-1);
                System.out.println("删除成功！");
                break;//就这个要写break；
            }
        }
        //没找到的情况
        if (i > bookList.getSize()) {  //会显示未找到该书
            System.out.println("没找到该书");
        }
    }
}
