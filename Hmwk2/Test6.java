public class Test6{
    public static void main(String[] args) {
        int a = 24;
        int b = 18;
        int t;
        while (true) {
            t = a % b;
            if(t == 0) {
                break;
            }else {
                a = b;
                b = t;
            }
        }
        System.out.println(b);
    }
}