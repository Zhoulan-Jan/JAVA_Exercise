package twelve;

public class Staff extends Employee {
    public String officeTime;
    public String level;
    public String title;

    public Staff(String name, String addr, String tele, String email, String office, String wage, String hireDate, String officeTime, String level, String title) {
        super(name, addr, tele, email, office, wage, hireDate);
        this.officeTime = officeTime;
        this.level = level;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "officeTime='" + officeTime + '\'' +
                ", level='" + level + '\'' +
                ", title='" + title + '\'' +
                ", office='" + office + '\'' +
                ", wage='" + wage + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", tele='" + tele + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
