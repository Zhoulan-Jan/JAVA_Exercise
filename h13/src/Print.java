public class Print {
    public static void print(int n) {
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                for (int j = 1; j <= n - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.println();
                continue;
            }
            if (i == n) {
                for (int j = 1; j <= 2*n - 1; j++) {
                    System.out.print("*");
                }
                continue;
            }
            int k = 1;
            for (; k <= n - i; k++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (;k < n + i - 2; k++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        print(7);
    }
}
