package five;

public class B  extends Circle{
    private double length;

    //错误语句
//    B(double radius, double length) {
//        Circle(radius);
//        length = length;
//    }

    //正确语句
    public B(double radius, double length) {
        super(radius);
        this.length = length;
    }

    public double getarea() {
        return getArea()*length;
    }
}
