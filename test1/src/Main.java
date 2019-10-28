import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        String ans = null;
//        int[] arr = new int[255];
//        for (int i = 0; i < str.length(); i++) {
//            arr[str.charAt(i)]++;
//        }
////        //字符数组全改为1
////        for (int k = 0; k < arr.length; k++) {
////            if (arr[k] != 0) {
////                arr[k] = 1;
////            }
////        }
//        for (int j = 0; j < str.length(); j++) {
//            if (arr[str.charAt(j)] > 0) {
//                System.out.print(str.charAt(j));
//                arr[str.charAt(j)] = 0;
//            }
//        }
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String str = sc.hasNextInt();
            String ans = null;
            int[] arr = new int[255];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i)]++;
            }
            for (int j = 0; j < str.length(); j++) {
                if (arr[str.charAt(j)] > 0) {
                    System.out.print(str.charAt(j));
                    arr[str.charAt(j)] = 0;
                }
            }
        }
    }
}
