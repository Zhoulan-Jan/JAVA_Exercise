public class Test1{
    public static void main(String[] args) {
        int age = 30;
        if (age < 18) {
            System.out.println("少年");
        } else if (age < 28) {
            System.out.println("青年");
        } else if (age < 55) {
            System.out.println("中年");
        } else if (age >56 ) {
            System.out.println("老年");
        }
    }
}