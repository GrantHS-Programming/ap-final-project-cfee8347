import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand = new ArrayList<>();
    private boolean dealer;
    private int seat;
    private int tricksTaken;
    private String name;

    public Player(String name){
        this.name = name;
    }


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
            System.out.print(hand.get(x).getCard() + ", ");
        }
        System.out.println("");
    }

    public int getTricksTaken(){
        return tricksTaken;
    }

    public void addTricksTaken(){
        tricksTaken += 1;
    }

    public int getHandSize(){
        return hand.size();
    }

    public Card getCardInHand(int cardIndex){
        return hand.get(cardIndex);
    }

    public Card removeCardFromHand(int index){
        return hand.remove(index);
    }

}
