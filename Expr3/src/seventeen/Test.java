package seventeen;

public class Test {
    public static void main(String[] args) {
        MyRectangle rectangle = new MyRectangle();
        rectangle.setHeighth(15);
        rectangle.setWidth(20);
        rectangle.showInfo();
        System.out.println("矩形面积 " + rectangle.getArea());

        MySquare square = new MySquare();
        square.setHeighth(30);
        square.showInfo();
        System.out.println("正方形面积 " + square.getArea());

    }
}
