package nine;

public class A {
    int i =1;
    static int j =2;

    //代码块
    {
        System.out.println("i = " + i);
    }

    //静态代码块
    static {
        System.out.println("j = " + j);
    }
}
