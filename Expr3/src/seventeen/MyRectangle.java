package seventeen;

public class MyRectangle {
    private int heighth;
    private int width;

    public int getHeighth() {
        return heighth;
    }

    public void setHeighth(int heighth) {
        this.heighth = heighth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea() {
        return heighth * width;
    }

    public void showInfo() {
        System.out.println(heighth +" " + width);
    }
}
