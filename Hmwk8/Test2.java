public class Test2{
    public static void main(String[] args) {
        Person Petter = new Person("petter",18,158,55);
        System.out.println(Petter.name);

        Person Ron = new Person("ron",18);
        System.out.println(Ron.age);

        Person Harry = new Person(188,55.6);
        System.out.println(Harry.height);
    }
}