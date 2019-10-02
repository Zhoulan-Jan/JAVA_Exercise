public class Exchange{
    public static void main(String[] args) {
        int[] arr = {20, 30};
        System.out.println("交换前：a = 20, b = 30");
        swap(arr);
        System.out.println("交换后：a = " + arr[0] + ", b = " + arr[1]);
    }

    public static void swap(int[] a) {
            int t = a[0];
            a[0] = a[1];
            a[1] = t;
    }
}