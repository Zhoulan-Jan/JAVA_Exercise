
public class Card {
    public String suit; //花色
    public String rank; //牌面值

    @Override
    public String toString() {
        return "[" + suit + " " + rank + "]";
        //return String.format("[%s %d]",suit,rank);
    }

}
