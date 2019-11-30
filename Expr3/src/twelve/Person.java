package twelve;

public class Person {
    public String name;
    public String addr;
    public String tele;
    public String email;

    public Person(String name, String addr, String tele, String email) {
        this.name = name;
        this.addr = addr;
        this.tele = tele;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", tele='" + tele + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
