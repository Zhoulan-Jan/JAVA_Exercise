package skd;

class Circle {
    double radius;
    Circle(double newRadius) {
        radius = newRadius;
    }
}
public class Test17 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(1);
        Circle circle2 = new Circle(2);
        swap1(circle1,circle2);
        System.out.println("圆一：" + circle1.radius + " 圆二：" +circle2.radius);
        swap2(circle1,circle2);
        System.out.println("圆一：" + circle1.radius + " 圆二："+circle2.radius);
    }

    public static void swap1(Circle x,Circle y) {
        Circle tmp = x;
        x = y;
        y = tmp;
    }

    public static void swap2(Circle x,Circle y) {
        double tmp = x.radius;
        x.radius = y.radius;
        y.radius = tmp;
    }
}
