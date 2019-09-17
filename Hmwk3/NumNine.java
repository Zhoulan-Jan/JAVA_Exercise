public class NumNine{
    public static void main(String[] args) {
        int cnt = 1;  //数字99
         for(int i = 1;i <= 100; i++){
            if(i == 9 || i % 10 == 9 || i/10 == 9){
                cnt=cnt+1;
            }
         }
         System.out.println("cnt:"+cnt);
    }
}