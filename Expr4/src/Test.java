import java.util.Random;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args) {
        one();
        two();
        three();
        //System.out.println((int) (Math.random()*6)+1);
        four();
        //five();
        //six();
        seven();
    }

    //
    public static void one(){
        System.out.println("第一题：");
        int x = 5;
        int y = 8;
        double d = 6.7;
        System.out.println("x的y次方：" + Math.pow(x,y));
        System.out.println("x和y的最小值：" + Math.min(x,y));
        System.out.println("d取整后的结果：" + Math.floor(d));
        System.out.println("d四舍五入后的结果：" + Math.round(d));
        System.out.println("tan(d)的数值：" +  Math.tan(d));
    }

    //
    public static void two() {
        System.out.println("第二题：");
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = new String("Hello");

        //比较身份
        System.out.println("s1 == s2：" + (s1==s2));
        System.out.println("s3 == s4：" + (s3==s4));
        System.out.println("s1 == s3：" + (s1==s3));

        //比较值
        System.out.println("s1 equals s2：" + (s1.equals(s2)));
        System.out.println("s3 equals s4：" + (s3.equals(s4)));
        System.out.println("s1 equals s3：" + (s1.equals(s3)));
    }

    //
    public static void three() {
        System.out.println("第三题：");
        Random ra = new Random();
        int one = 0; int two = 0; int three = 0;
        int four = 0; int five = 0; int six = 0;
        for (int i = 0; i < 1000; i++) {
            int x = ra.nextInt(6) + 1;
            switch (x) {
                case 1: one++; break;
                case 2: two++; break;
                case 3: three++; break;
                case 4: four++; break;
                case 5: five++; break;
                case 6: six++; break;
            }
        }
        System.out.println("one: " + one);
        System.out.println("two: " + two);
        System.out.println("three: " + three);
        System.out.println("four: " + four);
        System.out.println("five: " + five);
        System.out.println("six: " + six);
    }

    //获取数组元素的值 //得到最大值 得到最小值 得到平均值 元素之和
    public static void four() {
        System.out.println("第四题：");
        int[] arr = {5,2,4,7,3,6,9,5};
        int max = arr[0];
        int min = arr[0];
        double avg;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
            sum+=arr[i];
        }
        avg = sum*1.0/arr.length;
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
        System.out.println("平均值：" + avg);
        System.out.println("和：" + sum);
    }

    public static void five() {
        System.out.println("第五题：");
        Scanner sc = new Scanner(System.in);
        String specStr = sc.next();
        String str = sc.next();

        char[] specArr = specStr.toCharArray();
        int[] arr = new int[255];
        for (int i = 0; i < specArr.length; i++) {
            arr[specArr[i]]++;
        }
        for (int i = 0; i < str.length(); i++) {
            //删除arr[] != 0 的字符 即出现了指定字符串中的字母
            if (arr[str.charAt(i)] != 0) {
                continue;
            } else {
                System.out.print(str.charAt(i));
            }
        }
    }

    public static void six() {
        System.out.println("第六题：");
        Scanner sc = new Scanner(System.in);
        String specStr = sc.next();
        String str = sc.next();

        char[] specArr = specStr.toCharArray();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            //出现了指定字符串的字母
            if (str.charAt(i) == specArr[0]) {
                cnt++;
            }
        }
        System.out.println("指定字符串输出次数：" + cnt);
    }

    //字符串转换
    public static void seven() {
        System.out.println("第七题：");
        String str = "Let us study Java";
        System.out.println("转换成大写：" + str.toUpperCase());
        System.out.println("转换成小写：" + str.toLowerCase());
        System.out.println("替换空格：" + str.replace(' ','#'));
    }
}
