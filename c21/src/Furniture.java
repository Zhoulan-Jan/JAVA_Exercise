public class Furniture {
    private int id;
    private String name;
    private int price;
    private int num;
    private String dates;
    private String style;

    public Furniture(int id, String name, int price, int num, String dates, String style) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
        this.dates = dates;
        this.style = style;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
