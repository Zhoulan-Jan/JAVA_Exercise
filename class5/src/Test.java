public class Test {
    public static void main(String[] args) {
        testaddFirst();
        testaddLast();
        testsize();
        //testfindNode();
        testaddIndex();
        testcontains();
        testremove();
        testremoveAllKey();
    }

    public static void testaddFirst(){
        System.out.println("测试addFirst方法：");
        LinkedList klist = new LinkedList();
        klist.addFirst(1);
        klist.addFirst(2);
        klist.addFirst(3);
        klist.addFirst(4);
        klist.addFirst(5);
        System.out.print("预期结果是[5,4,3,2,1], 实际是：");
        klist.display();
    }

    public static void testaddLast(){
        System.out.println("测试addLast方法：");
        LinkedList klist = new LinkedList();
        klist.addLast(5);
        klist.addLast(4);
        klist.addLast(3);
        klist.addLast(2);
        klist.addLast(1);
        System.out.print("预期结果是[5,4,3,2,1], 实际是：");
        klist.display();
    }

    public static void testaddIndex(){
        System.out.println("测试addIndex方法：");
        LinkedList klist = new LinkedList();
        klist.addFirst(1);
        klist.addFirst(2);
        klist.addFirst(3);
        klist.addFirst(4);
        klist.addFirst(5);
        klist.addIndex(3,77);
        klist.addIndex(0,88);
        klist.addIndex(7,99);
        System.out.print("预期结果是[88,5,4,3,77,2,1,99], 实际是：");
        klist.display();
    }

    public static void testsize(){
        System.out.print("测试size方法：");
        LinkedList klist = new LinkedList();
        klist.addLast(5);
        klist.addLast(4);
        klist.addLast(3);
        klist.addLast(2);
        klist.addLast(1);
        int result = klist.size();
        System.out.println("预期结果是5, 实际是：" + result);
    }

    public static void testcontains(){
        System.out.print("测试contains方法：");
        LinkedList klist = new LinkedList();
        klist.addLast(5);
        klist.addLast(4);
        klist.addLast(3);
        klist.addLast(2);
        klist.addLast(1);
        boolean result = klist.contains(4);
        System.out.println("预期结果是true, 实际是：" + result);
    }

    public static void testremove(){
        System.out.println("测试remove方法：");
        LinkedList klist = new LinkedList();
        klist.addLast(5);
        klist.addLast(4);
        klist.addLast(3);
        klist.addLast(3);
        klist.addLast(2);
        klist.addLast(1);
        klist.remove(3);
        klist.remove(5);
        klist.remove(9);
        System.out.print("预期结果是[4,3,2,1], 实际是：");
        klist.display();
    }

    public static void testremoveAllKey() {
        System.out.println("测试removeAllKey方法：");
        LinkedList klist = new LinkedList();
        klist.addLast(5);
        klist.addLast(4);
        klist.addLast(3);
        klist.addLast(3);
        klist.addLast(2);
        klist.addLast(1);
        klist.addLast(3);
        klist.addLast(1);
        klist.removeAllKey(1);
        System.out.print("预期结果是[5,4,3,3,2,3], 实际是：");
        klist.display();
    }


//    public static void testfindNode(){
//        System.out.print("测试findNode方法：");
//        LinkedList klist = new LinkedList();
//        klist.addLast(5);
//        klist.addLast(4);
//        klist.addLast(3);
//        klist.addLast(2);
//        klist.addLast(1);
//        //int result = klist.findNodeIndex(3);
//        //System.out.println("预期结果是2, 实际是：" + result);
////        int result = klist.findNodeValue(3);
////        System.out.println("预期结果是3, 实际是：" + result);
//        int result = klist.findPrevNodeValue(3);
//        System.out.println("预期结果是4, 实际是：" + result);
//    }

}
