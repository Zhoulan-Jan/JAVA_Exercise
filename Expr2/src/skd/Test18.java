package skd;

public class Test18 {
//    public static void main(String[] args) {
//        int[] arr={1,2};
//        swap(arr[0],arr[1]);
//        System.out.println(arr[0] + " " + arr[1]);
//    }
//
//    public static void swap(int n1,int n2) {
//        int tmp = n1;
//        n1 = n2;
//        n2 = tmp;
//    }

//    public static void main(String[] args) {
//        int[] arr={1,2};
//        swap(arr);
//        System.out.println(arr[0] + " " + arr[1]);
//    }
//
//    public static void swap(int[] a) {
//        int t = a[0];
//        a[0] = a[1];
//        a[1] = t;
//    }

//    static class T{
//        int e1 = 1;
//        int e2 = 2;
//    }
//    public static void main(String[] args) {
//        T t = new T();
//        swap(t);
//        System.out.println(t.e1+" " + t.e2);
//    }
//    public static void swap(T t) {
//        int tmp = t.e1;
//        t.e1 = t.e2;
//        t.e2 = tmp;
//    }

    static class T{
        static int i = 0;
        int j = 0;
        T() {
            i++;
            j=i;
        }
    }
    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        System.out.println(t1.i + " " +t1.j);
        System.out.println(t2.i + " " +t2.j);
    }
}
