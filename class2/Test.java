
import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的名字：");
        String name = sc.nextLine();
        
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();

        System.out.println("请输入你的薪水");
        double salary = sc.nextDouble();

        System.out.println("您的信息：");
        System.out.println(name + " "+ age + " "+salary);
        sc.close();
    }
}