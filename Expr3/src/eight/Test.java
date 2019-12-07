package eight;

public class Test {
    public static void main(String[] args) {
        B b = new B();
        System.out.println("b.i " + b.i);
        System.out.println("b.j " + b.j);

        A a = new A();
        System.out.println("a.i " + a.i);
        System.out.println("a.j " + a.j);
        a.m();
        a.m1();
        System.out.println("a.i " + a.i);
        System.out.println("a.j " + a.j);
    }
}
