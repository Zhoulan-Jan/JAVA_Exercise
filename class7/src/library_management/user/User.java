package library_management.user;

import library_management.book.BookList;
import library_management.operation.IOperation;

//写成抽象类，被继承
//查找方法
public abstract class User {
    //字段
    protected String name;
    protected IOperation[] operations;  //领悟一下

    //构造方法
    public User(String name) {
        this.name = name;
    }

    //方法
    //选择哪个操作
    public abstract int menu(); //抽象方法 注定被覆写
    //根据操作选择类执行//不懂
//    public void doOperation(int choice, BookList bookList) {
//        operations[choice].work(bookList);
//    }

}
