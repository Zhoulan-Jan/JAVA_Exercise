package skd;

class StudentC {
    String name;
    char gender;
    int age;
    String[] courseNames;
    double[] courseScores;
    public StudentC () {
        name = "unknown name";
        gender = 'M';
        age = 0;
        courseNames = new String[3];
        courseScores = new double[3];
        courseNames[0] = "计算机";
        courseNames[1] = "数学";
        courseNames[2] = "英语";
        courseScores[0] = courseScores[1] = courseScores[2] = 0;
    }

    public StudentC(String n,char s,int a) {
        name = n;
        gender = s;
        age = a;
        courseNames = new String[3];
        courseScores = new double[3];
        courseNames[0] = new String("计算机");
        courseNames[1] = new String("数学");
        courseNames[2] = new String("英语");
        courseScores[0] = 0;
        courseScores[1] = 0;
        courseScores[2] = 0;
    }

    public void introduceMe() {
        System.out.println(name);
        System.out.println(gender);
        System.out.println(age);
        System.out.println("我的成绩还没有录入");
    }
}

public class Test23 {
    public static void main(String[] args) {
        StudentC stu1 = new StudentC();
        StudentC stu2 = new StudentC("张三",'M',23);

        stu1.introduceMe();
        System.out.println();
        stu2.introduceMe();
    }
}
