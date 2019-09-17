import java.util.Random;
import java.util.Scanner;

public class PasswordIn{
    public static void main(String[] args) {
        int cnt = 3;
        //系统生成一个密码
        Random rd = new Random();
        int passwd = rd.nextInt(100)+1; 
        // int passwd = 12;
        Scanner sc = new Scanner(System.in);
        //用户输入密码，开始猜
        while ( cnt != 0) {
           System.out.println("请输入密码：");
           int guess = sc.nextInt();
           if (guess != passwd ){
               System.out.println("输入错误");
               cnt=cnt-1;
           } else {
               System.out.println("输入正确");
               break;
           }
        }
        sc.close();
    }
}