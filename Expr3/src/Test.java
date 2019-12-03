
import fourteen.SA;
import fourteen.SB;
import one.Student;
import twelve.Employee;
import twelve.Faculty;
import twelve.Person;
import twelve.Staff;

public class Test {
    public static void main(String arg[]) {
        testOne();
        testTwelve();
        testfourteen();
    }

    //测试第一题
    public static void testOne() {
        Student student = new Student("周丹妮","女",18,"201706060112","计算机172",98);
        student.display();
    }

    //测试第十二题
    public static void testTwelve() {
        Person person = new Person("Potter","Hogwarts","7548261","651177@hg");
        System.out.println(person);

        twelve.Student student = new twelve.Student("Ron","Hogwarts",
                "756617","756384@hg");
        System.out.println(student);

        Employee employee = new Employee("Hagrid","Hogwarts",
                "8524","5314632@hg","hg","$55","1999.01.20");
        System.out.println(employee);

        Faculty faculty = new Faculty("Hermione","Hagrid","2662",
                "5145451@hg","hg","$65","1998.02.26");
        System.out.println(faculty);

        Staff staff = new Staff("Harry","Hagrid","236544","458331@hg",
                "hg","$26","1888.2.6","1233.11.2","教授","教师");
        System.out.println(staff);
    }

    //测试第十四题
    public static void testfourteen() {
        SA sa = new SA();
        SB sb = new SB();
        System.out.println("最大值: " + sa.f(18,24));
        System.out.println("最小公倍数: " + sb.f(18,24));
    }
}
