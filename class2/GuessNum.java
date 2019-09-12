import java.util.Random;
import java.util.Scanner;

public class GuessNum{
    public static void main(String[] args) {
        //系统生成一个数字
        Random random = new Random();
        int toGuess = random.nextInt(100)+1;
        //输入一个数字
        Scanner sc = new Scanner(System.in);
        //比较 
        while ( true ){
           System.out.println("请输入数字：");  
           int Guess=sc.nextInt();
           if (Guess < toGuess){
               System.out.println("猜低了");
           } else if (Guess > toGuess){
               System.out.println("猜高了");
           } else {
               System.out.println("猜对了");
               break;
           }
        }
        sc.close();
    }
}