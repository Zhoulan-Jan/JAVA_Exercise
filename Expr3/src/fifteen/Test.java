package fifteen;

public class Test {
    public static void main(String[] args) {
        Pointer a = new Pointer(5,7);
        Pointer b = new Pointer(6,9);
        //求两点之间的距离
        System.out.println(a.distance(b));
        //两个点坐标的中点
        Pointer mid = new Pointer((a.x+b.x)/2,(a.y+b.y)/2);
        System.out.println(mid);
    }
}
