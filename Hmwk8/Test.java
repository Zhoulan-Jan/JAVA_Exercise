public class Test{
    public static void main(String[] args) {
        testadd();
        testsub();
        testmul();
        testexc();
    }

    public static void testadd() {
        Calculator x = new Calculator();
        x.num1 = 20;
        x.num2 = 30;
        int result = x.num1 + x.num2;
        System.out.println("预期结果是50，实际是："+ result);
    }

    public static void testsub() {
        Calculator x = new Calculator();
        x.num1 = 20;
        x.num2 = 30;
        int result = x.num1 - x.num2;
        System.out.println("预期结果是-10，实际是："+ result);
    }

    public static void testmul() {
        Calculator x = new Calculator();
        x.num1 = 20;
        x.num2 = 30;
        int result = x.num1 * x.num2;
        System.out.println("预期结果是600，实际是："+ result);
    }

    public static void testexc() {
        Calculator x = new Calculator();
        x.num1 = 30;
        x.num2 = 20;
        int result = x.num1 / x.num2;
        System.out.println("预期结果是1，实际是："+ result);
    }
}