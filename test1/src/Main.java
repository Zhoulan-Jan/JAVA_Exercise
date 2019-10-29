import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //单组输入
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        int[] arr = new int[255];
//        for (int i = 0; i < str.length(); i++) {
//            arr[str.charAt(i)]++;
//        }
//        for (int j = 0; j < str.length(); j++) {
//            if (arr[str.charAt(j)] > 0) {
//                System.out.print(str.charAt(j));
//                arr[str.charAt(j)] = 0;
//            }
//        }
        //多组输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
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
