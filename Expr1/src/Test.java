
public class Test {
    public static void main(String[] args) {
        System.out.println("打印hello");
        Print();

        System.out.println("打印素数");
        Prime(1000);

        System.out.println("打印完数");
        completeNum(1000);

        System.out.println("阶乘之和");
        System.out.println(sumOfFac() - 1);

        System.out.println("打印水仙花数");
        Daffodil();

        System.out.println("观察结果");
        test();
    }

    public static void Print() {
        System.out.println("hello");
    }

    public static void Prime(int n) {
        int i, j;
        for (i = 2;i < n; i++) {
            for (j = 2; j < i/2; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (i/2 <= j) {
                System.out.print(i + " ");
            }
        }
        System.out.println(" ");
    }

    //一个数恰好等于它的因子之和
    public static void completeNum(int n) {
        int i,j;
        int sum = 0;
        for (i = 6; i <= n; i++) {
            sum = 0;
            for (j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.print(i + " ");
            }
        }
        System.out.println(" ");
    }

    //阶乘之和
    public static int sumOfFac() {
        int i,j;
        int fac = 1;
        int sum = 0;
        for (i = 1; i <= 10; i++) {
            fac = 1;
            for (j = 1; j <= i; j++) {
                fac *= j;
            }
            sum += fac;
            if (sum > 9999) {
                System.out.println(" ");
                return i;
            }
        }
        return 0;
    }

    //水仙花数
    public static void Daffodil() {
        for (int i = 100; i <= 999; i++) {
            int x = i % 10; //个位
            int y =( i / 10 ) % 10;  //十位
            int z = i / 100; //百位
            if (x*x*x + y*y*y +z*z*z == i) {
                System.out.print(i + " ");
            }
        }
        System.out.println(" ");
    }

    //观察结果
    public static void test(){
        char c = '\0';
        for (int i = 1; i <= 4; i++) {
            switch (i) {
                case 1: c = '你';
                    System.out.println(c);
                case 2: c = '好';
                    System.out.println(c);
                    break;
                case 3: c = '酷';
                    System.out.println(c);
                default:
                    System.out.println("!");
            }
        }
    }

}
