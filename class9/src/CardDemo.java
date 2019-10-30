import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDemo {
    public static final String[] SUITS = {"♥","♠","♣","♦"};

    //创建一副牌
    public static List<Card> buyDeck() {
        List<Card> deck = new ArrayList<>(52);
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                Card card = new Card();
                card.suit = SUITS[i];  //不能放在外面
                card.rank = j + "";
                deck.add(card);
            }
//            Card card = new Card();card.suit = SUITS[i];
//            card.rank = "A"; deck.add(card);
//            card.rank = "Q"; deck.add(card);
//            card.rank = "J"; deck.add(card);
//            card.rank = "K"; deck.add(card); //AQJK要如何写？
        }
        return deck;
    }
    public static void main(String[] args) {
        //创建一副牌
        List<Card> deck = buyDeck();
        System.out.println("刚买回来的牌：");
        System.out.println(deck);
        //洗牌
        Collections.shuffle(deck);
        System.out.println("洗了之后的牌：");
        System.out.println(deck);
        //发牌  三个玩家，每个玩家五张牌
        List<List<Card>> player = new ArrayList<>();
        player.add(new ArrayList<Card>());
        player.add(new ArrayList<Card>());
        player.add(new ArrayList<Card>());
        //先是每个玩家发一张牌，
        for (int cardIndex = 0 ; cardIndex < 5; cardIndex++) {
            for (int playerIndex = 0; playerIndex < 3; playerIndex++) {
                    player.get(playerIndex).add(deck.remove(0));
            }
        }
        //输出玩家手牌
        System.out.print("A的牌：");
        System.out.println(player.get(0));
        System.out.print("B的牌：");
        System.out.println(player.get(1));
        System.out.print("C的牌：");
        System.out.println(player.get(2));
    }
}
