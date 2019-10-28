import java.util.StringTokenizer;

/**     1.equals
        2. compareTo
        3. toCharArray
        4. contains
        5. indexOf
        6. lastIndexOf
        7. replaceAll
        8. replaceFirst
        9. split
        10. subString
        11. trim
        12. isEmpty
        13. length
*/
public class Test {
    public static void main(String[] args) {
        //字符串比较
//        //字符串常量只在内存中存了一份 字符串常量池
//        String str1 = "Hello World";
//        String str2 = "Hello World";
//        System.out.println(str1 == str2);  //true
//        //创建一个字符串对象
//        String str3 = new String("hello world");
//        String str4 = new String("hello world");
//        System.out.println(str3 == str4); //false
//        System.out.println(str3.equals(str4)); //true
//        //不区分大小写的比较
//        String str5 = "hello world";
//        System.out.println(str1.compareToIgnoreCase(str5)); //0
//        System.out.println(str1.equalsIgnoreCase(str5)); //true
//        //区分大小写的比较
//        System.out.println(str1.compareTo(str3)); //-32

        //字符串查找
//        String str1 = "Hello world!";
//        String str2 = "world";
//        String str3 = "H";
//        System.out.println(str1.contains(str2));  //判断字串是否存在 //true
//        System.out.println(str1.indexOf(str2));  //指定字符串开始的位置 //6
//        System.out.println(str1.indexOf(str2,5)); //从指定位置查找子串
//        System.out.println(str1.lastIndexOf(str2)); //从后向前寻找子串 //6
//        System.out.println(str1.startsWith(str3)); //true

        //字符串替换
//        String str1 = "hello world";
//        System.out.println(str1.replaceAll("l","-"));
//        System.out.println(str1.replaceFirst("o","*"));

        //字符串拆分
//        String str1 = "hello world and hello bit!";
//        String[] res1 = str1.split(" ");
//        for (String s : res1) {
//            System.out.println(s);
//        }
//        //多次拆分
//        String str2 = "name=wangwu&age=18";
//        String[] res2 = str2.split("&");
//        for (int i = 0; i < res2.length; i++) {
//            String[] tmp = res2[i].split("=");
//            for (int j = 0; j < tmp.length; j++) {
//                System.out.println(tmp[j]);
//            }
//        }

        //字符串截取
//        String str1 = "helloworld";
//        //取子串
//        System.out.println(str1.substring(4));

//        //去掉字符串前后空格
//        String str2 = "      danni  cool  ";
//        System.out.println(str2.trim());
//        //取得字符串长度
//        System.out.println(str2.length());
//        //字符串是否为空
//        System.out.println(str2.isEmpty()); //false
//        System.out.println("".isEmpty()); //true 长度为零
//        System.out.println(new String().isEmpty()); //true 长度为零

        //首字母大写
        System.out.println(firstUpper("hello"));
        System.out.println(firstUpper(" "));
        System.out.println(firstUpper("a"));
    }

    public static String firstUpper (String str) {
        //非法字符串
        if (str.length() <= 0 || str == null) {
            return str;
        }
        //长度大于1
        if (str.length() > 1) {
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
        //长度为1
        return str.toUpperCase();
    }
}
