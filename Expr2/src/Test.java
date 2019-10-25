import skd.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) throws ParseException {
        testOne();
        testTwo();
        testFour();
        testFive();
        testSix();
        testSeven();
        testEight();
        testNine();
        //下面是日历测试代码
//        Calendar cal = Calendar.getInstance();
//        //cal.set(Calendar.DAY_OF_WEEK,Calendar.JANUARY);  //确定月份 Jan 30 Feb 31 March 31
//        cal.set(Calendar.DAY_OF_MONTH,Calendar.JANUARY);
//        cal.set(Calendar.DAY_OF_YEAR,2018);
//        System.out.println(cal.get(Calendar.MONTH)); //得到月份  怎么修改都是9？？
//        System.out.println(cal.get(Calendar.YEAR)); //2019
//        int days = cal.getActualMaximum(Calendar.DATE);
//        System.out.println("days = " + days);
//        int startDay = cal.get(Calendar.DAY_OF_WEEK); //这个函数不对啊aaa
//        System.out.println(startDay);//6  六 0  日 1 一 2 二 3 三 4 四 5 五 6
    }

    public static void testOne() {
        System.out.println("测试第一题：");
        Student student = new Student();
        student.setAge(18);
        System.out.println(student.getAge());
    }

    public static void testTwo() {
        System.out.println("测试第二题：");
        StudentB studentB = new StudentB("123","1班",
                "李莉","女",19);
        System.out.println(studentB);
    }

    public static void testFour() {
        System.out.println("测试第四题：");
        MyDate date = new MyDate(1999,11,12);
        System.out.println(date.showDate());
    }

    public static void testFive() {
        System.out.println("测试第五题：");
        Rectangle rect1 = new Rectangle(4,40,"黄色");
        Rectangle rect2 = new Rectangle(3.5,35.9,"红色");
        System.out.println("矩形1：width：" + rect1.getWidth() + "  height：" + rect1.getHeight()
                + "  color:" + rect1.getColor() + "  area:" + rect1.getArea()+"  perimeter:" + rect1.getPerimeter());
        System.out.println("矩形2：width：" + rect2.getWidth() + "  height：" + rect2.getHeight()
                + "  color:" + rect2.getColor()+ "  area:" + rect2.getArea()+"  perimeter:" + rect2.getPerimeter());

    }

    public static void testSix() {
        System.out.println("测试第六题：");
        MyInteger val = new MyInteger(15);
        System.out.println("测试isEven：" + val.isEven());
        System.out.println("测试isOdd：" + val.isOdd());
        System.out.println("测试isPrime：" + val.isPrime());
        System.out.println("测试equals：" + val.equals(23));
        System.out.println("测试parseInt：" + val.parseInt("123456"));
    }

    public static void testSeven() {
        System.out.println("测试第七题：");
        MyPoint point1 = new MyPoint(2,3);
        MyPoint point2 = new MyPoint(10,30.5);
        System.out.println("两点距离为：" + point1.distance(point1,point2));
    }

    public static void testEight() {
        System.out.println("测试第八题：");
        Course course = new Course("001",
                "离散","4.5");
        System.out.println(course.printCourseInfo());
    }

    public static void testNine() {
        System.out.println("测试第九题：");
        Acount acount = new Acount();
        acount.setId(1122);
        acount.setBalance(20000);
        acount.setAnnualInterestRate(0.045);
        acount.withDraw(2500);
        acount.deposit(3000);
        System.out.println("余额为：" + acount.getBalance());
        System.out.println("月利率为：" + acount.getMonthlyInterestRate());
        System.out.println("开户日期为：" + acount.getDateCreated());
    }
}
