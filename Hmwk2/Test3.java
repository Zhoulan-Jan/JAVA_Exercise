public class Test3{
    public static void main(String[] args) {
        int j = 0;
        for (int i = 5; i <= 100; i++){
            for(j = 2; j < i/2; j++){
                if (i % j == 0){
                    break;
                }
            }
            if (j == i/2) {
                System.out.println(i);
            }
        }
    }
}