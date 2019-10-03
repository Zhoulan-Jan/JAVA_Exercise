public class Exam {
    public static void main(String[] args) {
        String id = "34052419800133001X";
        System.out.println(id.length());

        int sum = 0;
        int[] value = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        for (int i = 0; i < value.length; i++) {
            sum += value[i] * (id.charAt(i) - '0');  //注意ascii码 //189
        }
        System.out.println(sum);

        char[] code = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int ans = sum % 11;
        System.out.println("ans = " + ans);
//        if (code[ans] == id.charAt(17)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }


//        //判断年月日是否正确
//        int years = (id.charAt(6)-'0') * 1000 + (id.charAt(7)-'0') * 100 + (id.charAt(8)-'0') * 10 + (id.charAt(9)-'0') ;
//        if (years >= 1949 && years < 2020) {  //年份正确
//            int month = (id.charAt(10) - '0') * 10 + (id.charAt(11) - '0');
//            if (month > 0 && month < 13) {
//                int day = (id.charAt(12) - '0') * 10 + (id.charAt(13) - '0');
//                //非闰年
//                if (!leapYear(years)) {
//                    int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
//                    if (day > 0 && day <= days[month]) {
//                        System.out.println("正确");
//                    }
//                }
//                //闰年
//                if (leapYear(years)) {
//                    int[] days = {0,31,29,31,30,31,30,31,31,30,31,30,31};
//                    if (day > 0 && day <= days[month]) {
//                        System.out.println("正确");
//                    }
//                }
//            }
//        } else {
//            System.out.println("错误");
//        }
//    }
//
//    //判断闰年
//    public static boolean leapYear(int year) {
//        if (year % 100 == 0) {
//            if (year % 400 == 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            if (year % 4 == 0) {
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }


    }
}
