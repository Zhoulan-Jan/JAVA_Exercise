public class Factorial{
    public static void main(String[] args) {
        int n = 5;
        int ans = Fac(n);
        System.out.println("ans = "+ans);
    }

    public static int Fac(int n){
        if (n == 1) return 1;
        else return n * Fac(n - 1);  //if(n > 1)错误 
    }
}