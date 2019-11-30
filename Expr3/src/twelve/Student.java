package twelve;

public class Student extends Person {
    final String firstGrade = "一年级";
    final String secondGrade = "二年级";
    final String thirdGrade = "三年级";
    final String fourthGrade = "四年级";

    public Student(String name, String addr, String tele, String email) {
        super(name, addr, tele, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "thirdGrade='" + thirdGrade + '\'' +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", tele='" + tele + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
