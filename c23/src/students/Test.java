package students;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student("张三",94),
                new Student("王五",92),
                new Student("李四",98),
                new Student("赵六",88),
                new Student("周七",77)
        };
        Arrays.sort(students);  //没有实现comparable接口前 无法排序
        System.out.println(Arrays.toString(students));
    }
}
