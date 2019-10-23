package library_management.user;

import library_management.operation.*;

import java.util.Scanner;

public class Admin extends User{

    public Admin(String name) {
        super(name);
        operations = new IOperation[] { //为什么构造方法可以这么写啊
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new PrintAllOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("==========");
        System.out.println("1.查找书籍");
        System.out.println("2.增加书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.打印所有书籍信息");
        System.out.println("==========");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();  //c语言要写while循环 这里不用
        return choice;
    }
}
