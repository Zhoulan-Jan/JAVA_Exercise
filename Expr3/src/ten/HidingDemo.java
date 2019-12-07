package ten;

public class HidingDemo {
    public static void main(String[] args) {
        A x = new B();
        System.out.println("1. x.i = " + x.i);
        System.out.println("2. ((B)x).i = " + ((B)x).i);

        System.out.println("3. x.j = " + x.j);
        System.out.println("4. ((B)x).j = " + ((B)x).j);

        System.out.println("5. x.m1() = " + x.m1());
        System.out.println("6. ((B)x).m1() = " + ((B)x).m1());

        System.out.println("7. x.m2() = " + x.m2());
        System.out.println("8. x.m3() = " + x.m3());
    }
}
