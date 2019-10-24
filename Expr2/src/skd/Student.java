package skd;

public class Student {
    //字段
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
}
