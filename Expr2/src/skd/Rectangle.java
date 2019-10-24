package skd;

public class Rectangle {
    private double width = 1.0;
    private double height = 1.0;
    private String color = "白色";

    public Rectangle() {

    }

    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return width*height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }
}
