package five;

public class Circle {
    private double radius;

    //错误语句
//    public Circle (double radius) {
//        radius = radius;
//    }

    //正确语句
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return radius * radius*Math.PI;
    }


}
