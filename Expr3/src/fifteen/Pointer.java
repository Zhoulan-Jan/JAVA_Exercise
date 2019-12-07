package fifteen;

public class Pointer {
    double x;
    double y;

    //构造方法
    public Pointer(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pointer{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pointer pointer = (Pointer) o;
        return x == pointer.x &&
                y == pointer.y;
    }

    //类方法
    public double distance(Pointer b) {
        double x = Math.pow(this.x - b.x,2) + Math.pow(this.y - b.y,2);
        return Math.sqrt(x);
    }
}
