package skd;

class AAA {
    String s;
    AAA(String s) {
        this.s = s;
    }

    public void print() {
        System.out.println(s);
    }
}
public class Test12 {
    public static void main(String[] args) {
        AAA a = new AAA("w");
        a.print();
    }
}
