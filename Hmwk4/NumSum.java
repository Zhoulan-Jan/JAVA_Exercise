public class NumSum{
    public static void main(String[] args) {
        int n = 34345;
        int ans = Sum(n);
        System.out.println("ans = "+ans);
    }

    public static int Sum(int num){
       if (num < 10){
           return num;
       }
       return num % 10 +Sum(num / 10);
    }
}