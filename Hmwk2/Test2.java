public class Test2{
    public static void main(String[] args) {
        int num = 8;
        int i = 0;
        for (i = 2; i < num/2; i++){
            if (num % 2 == 0){
                System.out.println("不是素数");
                break;
            }
        }
        if (i == num/2){
            System.out.println("是素数");
        }
    }
}