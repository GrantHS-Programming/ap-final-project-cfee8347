import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand = new ArrayList<>();
    private String name;

    public Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

}
