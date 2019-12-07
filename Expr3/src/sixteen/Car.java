package sixteen;

public class Car extends Vehlcles {
    public Car(int size, String color, int seats) {
        super(size, color, seats);
    }

    @Override
    public String toString() {
        return "Car{" +
                "size=" + size +
                ", color=" + color +
                ", seats=" + seats +
                '}';
    }
}
