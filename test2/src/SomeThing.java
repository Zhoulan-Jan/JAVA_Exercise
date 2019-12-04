import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SomeThing {
    public static int getNum(String[] str) { //一组带空格的字符串？
        int v = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (!map.containsKey(str[i])) {
                map.put(str[i], v++);
            }
        }
        //BUTTER FLOUR
        //HONEY FLOUR EGGSystem.out.println(map.size());
        return map.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = new String[50];
        int index = 0;
                                      //如何知道输入结束啊
            String str = sc.nextLine();
            s[index++] = str;
            System.out.println(Arrays.toString(s));
            System.out.print(getNum(s) + " ");

    }
}
