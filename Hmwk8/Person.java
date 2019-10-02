public class Person {
    public String name;
    public int age;
    public double height;
    public double weight;

    public Person(String name, int age, double height, double weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }
}