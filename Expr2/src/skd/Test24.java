package skd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test24 {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入年份：");
        Scanner sc = new Scanner(System.in);
        String year = sc.next();
        int yearInt = Integer.parseInt(year); //字符转int
        Calendar cal = Calendar.getInstance();
//        cal.setTime(java.sql.Date.valueOf(year));
       cal.set(Calendar.YEAR, Integer.parseInt(year));
        //判断闰年
        //数组只能初始化一次
        if (isLeapyear(yearInt)) {
            int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};  //局部变量
            Print(month,yearInt);
        } else {
            int[] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
            Print(month,yearInt);
        }
    }

    public static boolean isLeapyear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }

    public static void Print(int[] month,int year) throws ParseException {
        String[] monthName = {"0","January","Febuary","March","April",
                "May","June","July","August","September",
                "October","November","December"} ;
        Calendar cal = Calendar.getInstance();
        for (int i = 1; i <= 12; i++) {
            System.out.println("Month's name is " + monthName[i]);
            System.out.println("===============================");
            System.out.print("Sun\t"+"Mon\t"+"Tue\t"+"Wed\t"+"Thu\t"+"Fri\t"+"Sat\t");
            System.out.println();
            //考虑第一天之前的空格 error
//            cal.set(Calendar.MONTH,month[i]);
//            int startDay = cal.get(Calendar.DAY_OF_WEEK);
            int startDay = getStart(year,i) - 1;
            for (int x = 0; x < startDay; x++) {
                System.out.print("\t");
            }
            for (int j = 1; j <=month[i]; j++) {
                System.out.printf("%2d\t",j);
                if ((j +startDay) % 7 == 0 ) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    public static int getStart(int year,int month) throws ParseException {
        GregorianCalendar now = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(year + "-" + month + "-01");
        // 设置当前时间
        now.setTime(date);
        // 从日期中取得当前的月 //int month = now.get(Calendar.MONTH);
        // 设置now的日期为1
        now.set(Calendar.DAY_OF_MONTH, 1);
        // 得到now是一周的第几天
        return now.get(Calendar.DAY_OF_WEEK);
    }
}
