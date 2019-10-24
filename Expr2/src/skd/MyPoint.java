package skd;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {

    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(MyPoint p1,MyPoint p2) {
        double z = (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y) *(p1.y - p2.y);
        return java.lang.Math.sqrt(z);
    }
}
