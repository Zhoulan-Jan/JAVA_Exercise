package skd;

public class Test16 {
    public static void main(String[] args) {
        Count myCount = new Count();
        int times = 0;
        for (int i = 0; i< 100;i++) {
            increment(myCount,times);
            System.out.println(myCount.count);
            System.out.println(times);
        }
    }

    public static void increment(Count C,int times) {
        C.count++;
        times++;
    }
}
