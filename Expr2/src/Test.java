import skd.*;

public class Test {
    public static void main(String[] args) {
        testOne();
        testTwo();
        testFour();
        testFive();
        testSix();
        testSeven();
        testEight();
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
}
