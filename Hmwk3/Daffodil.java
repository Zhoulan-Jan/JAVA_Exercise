public class Daffodil{
    public static void main(String[] args) {
        int i = 0;
        int x = 0; //个位
        int y = 0; //十位
        int z = 0; //百位
        for (i = 100; i <= 999; i++) {
            x = i % 10;
            z = i / 100;
            y = i / 10 - z * 10;
            if(x*x*x+y*y*y+z*z*z == i){
                System.out.println(i);
            }
        }
    }
}