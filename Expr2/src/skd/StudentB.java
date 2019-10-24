package skd;

public class StudentB {
    private String studentId;
    private String classNum;
    private String name;
    private String sex;
    private int age;

    public String getClassNum() {
        return classNum;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentB(String studentId, String classNum, String name, String sex, int age) {
        this.studentId = studentId;
        this.classNum = classNum;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentB{" +
                "学号='" + studentId + '\'' +
                ", 班级='" + classNum + '\'' +
                ", 姓名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 年龄=" + age +
                '}';
    }
}
