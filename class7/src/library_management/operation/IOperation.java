package library_management.operation;

import library_management.book.BookList;

public interface IOperation {
    void work(BookList bookList);  //接口只能包含抽象方法
}
