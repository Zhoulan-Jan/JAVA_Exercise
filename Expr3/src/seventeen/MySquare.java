package seventeen;

public class MySquare extends MyRectangle{

    @Override
    public int getWidth() {
        return super.getHeighth();
    }

    @Override
    public int getArea() {
        return getHeighth() * getHeighth();
    }

    @Override
    public void showInfo() {
        System.out.print(getHeighth() + " "+ getHeighth());
        System.out.println();
    }
}
