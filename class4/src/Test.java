
public class Test {
    public static void main(String[] args) {
        SeqList slist = new SeqList();
        testAdd();
        testContains();
        testSearch();
        testgetPos();
        testsetPos();
    }


    public static void testAdd() {
        //System.out.println("这是一个add方法：");
        SeqList slist = new SeqList();
        slist.add(0, 11);  // slist定义在外面也不行，静态方法里不能调用非静态的
        slist.add(1,22);
        slist.add(2,33);
        slist.add(3,44);
        slist.add(4,55);
        slist.add(5,66);
        slist.add(6,77);
        slist.add(3,88);
        slist.add(3,99);

        slist.display();
    }

    public static void testContains() {
        System.out.print("这是一个contains方法：");
        SeqList slist = new SeqList();  //我直接把add构造顺序表调用，slist未定义；重写slist再调用add就是新的空的顺序表
        slist.add(0,11);
        slist.add(1,22);
        slist.add(2,33);
        slist.add(3,44);
        slist.add(4,55);
        slist.add(5,66);
        slist.add(6,77);
        slist.add(3,88);
        slist.add(3,99);
//        testAdd();
        boolean result = slist.contains(99);
        System.out.println("预期答案是true，实际结果是：" + result);
    }

    public static void testSearch() {
        System.out.print("这是一个search方法：");
        SeqList slist = new SeqList();
        slist.add(0,11);
        slist.add(1,22);
        slist.add(2,33);
        slist.add(3,44);
        slist.add(4,55);
        slist.add(5,66);
        slist.add(6,77);
        slist.add(3,88);
        slist.add(3,99);
        int result = slist.search(99);
        System.out.println("预期答案是3，实际结果是：" + result);
    }

    public static void testgetPos() {
        System.out.print("这是一个getPos方法：");
        SeqList slist = new SeqList();
        slist.add(0,11);
        slist.add(1,22);
        slist.add(2,33);
        slist.add(3,44);
        slist.add(4,55);
        slist.add(5,66);
        slist.add(6,77);
        slist.add(3,88);
        slist.add(3,99);
        int result = slist.getPos(3);
        System.out.println("预期结果是99，实际是：" + result);
    }

    public static void testsetPos(){
        System.out.print("这是一个setPos方法：");
        SeqList slist = new SeqList();
        slist.add(0,11);
        slist.add(1,22);
        slist.add(2,33);
        slist.add(3,44);
        slist.add(4,55);
        slist.add(5,66);
        slist.add(6,77);
        slist.add(3,88);
        slist.add(3,99);
        slist.setPos(3,100);
        System.out.print("预期结果是:" );
        slist.display();
        System.out.print("实际结果是：");
        slist.display();
    }
}
