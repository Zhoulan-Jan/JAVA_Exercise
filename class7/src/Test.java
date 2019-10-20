import library_management.book.BookList;
import library_management.user.Admin;
import library_management.user.NormalUser;
import library_management.user.User;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //1.准备好书籍信息输入
        BookList bookList = new BookList();
        //2.创建用户，用户登录
        User user = login();
        //3.主循环
//        while (true) {
//            int choice = user.menu();  //menu方法是抽象方法，public留着是对的  去掉就错了
//            user.doOperation(choice,bookList);
//        }
    }

    public static User login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = sc.next();
        System.out.println("请选择你的身份：1.普通用户， 2.图书管理员");
        int role = sc.nextInt();
        if (role == 1) {
            return new NormalUser(name);
        } else {
            return new Admin(name);
        }
    }
}

