import java.util.Scanner;

public class ToFib {

    //得到  < n 的斐波那契数列
    public static int getFibonacci(int n) {
        int first = 0;
        int second = 1;
        int third = first + second;
        for (int i = 2; second < n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        //循环结束后， first 是比 n 小一点的数， second 是比 n 大一点的数
        int step1 = n - first;
        int step2 = second - n;
        return step1 < step2 ? step1 : step2;
    }
    public static void main(String[] args) {
//        System.out.println(getFibonacci(15)); //得到比 n 大一点的数  //第 6 个数是 5
//        System.out.println(getFibonacci(7));
//        System.out.println(getFibonacci(8));
//        System.out.println(getFibonacci(9));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println( getFibonacci(n));
        }
    }
}
