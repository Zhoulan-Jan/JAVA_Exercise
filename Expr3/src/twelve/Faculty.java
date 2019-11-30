package twelve;

public class Faculty extends Employee {
    public Faculty(String name, String addr, String tele, String email, String office, String wage, String hireDate) {
        super(name, addr, tele, email, office, wage, hireDate);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "office='" + office + '\'' +
                ", wage='" + wage + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", tele='" + tele + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
