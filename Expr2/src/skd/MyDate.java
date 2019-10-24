package skd;

public class MyDate {
    //字段
    private int year;
    private int month;
    private int day;

    //构造方法
    public MyDate(int y,int m,int d) {
        year = y;
        month = m;
        day = d;
    }

    //成员方法
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String showDate() {  //仿照toString写的
        return year+" 年 " + month +" 月 " + day + "日";
    }
}
