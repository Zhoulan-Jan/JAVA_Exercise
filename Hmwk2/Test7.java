public class Test7{
    public static void main(String[] args) {
        double sum = 0.0;
        int flag = 1;
        int i;
        for (i = 1; i <= 100; i++) {
            sum+=flag*(1.0/i);
            flag=-flag;
        }
        System.out.println(sum);
    }
}