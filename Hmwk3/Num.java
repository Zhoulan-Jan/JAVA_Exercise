public class Num{
    public static void main(String[] args) {
        //递归
        int n = 456789;
        Print(n);
    }

    public static void Print(int n){
        if ( n > 9 ){
            Print( n / 10);
        }
         System.out.println(n % 10);
    }
}