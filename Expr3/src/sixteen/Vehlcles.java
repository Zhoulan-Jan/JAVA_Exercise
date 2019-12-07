package sixteen;

public class Vehlcles {
    public int size;
    public String color;
    public int seats;

    //构造方法
    public Vehlcles(int size, String color, int seats) {
        this.size = size;
        this.color = color;
        this.seats = seats;
    }

    //显示信息方法
    @Override
    public String toString() {
        return "Vehlcles{" +
                "size=" + size +
                ", color=" + color +
                ", seats=" + seats +
                '}';
    }
}