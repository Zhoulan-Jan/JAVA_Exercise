package twelve;

public class Employee extends Person {
    public String office;
    public String wage;
    public String hireDate;

    public Employee(String name, String addr, String tele, String email, String office, String wage, String hireDate) {
        super(name, addr, tele, email);
        this.office = office;
        this.wage = wage;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
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
