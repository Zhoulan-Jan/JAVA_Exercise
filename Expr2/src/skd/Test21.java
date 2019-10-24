package skd;

class AA {
    double f(double x, double y) {
        return x+y;
    }
    static int g(int n) {
        return n*n;
    }
}
class BB extends AA {
    double f(double x,double y) {
        double m = super.f(x,y);
        return m+x*y;
    }
    static int g(int n) {
        int m = AA.g(n);
        return m+n;
    }
}
public class Test21 {
    public static void main(String[] args) {
        BB b = new BB();
        System.out.println(b.f(10.0,8.0));
        System.out.println(BB.g(3));
    }
}
