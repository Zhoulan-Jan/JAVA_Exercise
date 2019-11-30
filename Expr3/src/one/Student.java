package one;

import one.Person;

public class Student extends Person {
    public String id;
    public String cname;
    public int score;

    //显示学生信息
    public void display() {
        System.out.println(name + " " + gender + " " + age + " " +
                id +" " + cname +  " " + score);
    }

    public Student(String name, String gender, int age, String id, String cname, int score) {
        super(name, gender, age);
        this.id = id;
        this.cname = cname;
        this.score = score;
    }
}
