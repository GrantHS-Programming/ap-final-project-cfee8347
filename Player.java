import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand = new ArrayList<>();
    private boolean dealer;
    private int seat;


    public ArrayList<Card> getHand(){
        return hand;
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

    public void setDealer(Boolean isDealer){
        dealer = isDealer;
    }

    public boolean isDealer(){
        return dealer;
    }

    public void setSeat(int seat){
        this.seat = seat;
    }

    public int getSeat(){
        return seat;
    }

    public void printHand(){
        for (int x = 0; x < hand.size(); x++){
            System.out.print(hand.get(x).getNum() + " of " + hand.get(x).getSuit() + "s, ");
        }
        System.out.println("");
    }

}
