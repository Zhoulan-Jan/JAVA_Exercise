package skd;

class A{
    double f(double x, double y) {
        return x + y;
    }
}
class B extends AA {
    double f(int x, int y) {
        return x*y;
    }
}
public class Test20 {
    public static void main(String[] args) {
        BB b = new BB();
        System.out.println(b.f(3,5));
        System.out.println(b.f(3.0,5.0));
    }
}
