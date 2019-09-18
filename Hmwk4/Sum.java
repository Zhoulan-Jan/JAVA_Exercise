public class Sum{
    public static void main(String[] args) {
        int n = 10;
        int ans = getSum(n);
        System.out.println("ans = "+ans);
    }

    public static int getSum(int n){
        if (n == 1) return 1;
        else return n + getSum(n - 1);
    }
}