import java.util.ArrayList;

public class EuchreGame {

    public static void main(String[] args) {
        addCards();
        printDeck();
    }

    static ArrayList<Card> deck = new ArrayList<>();

    public static void addCards(){
        for (int x = 0; x < 4; x++){
            for (int y = 9; y <= 13; y++){
                if (x == 0){
                    deck.add(new Card(y, "Club"));
                } else if (x == 1){
                    deck.add(new Card(y, "Diamond"));
                } else if (x == 2){
                    deck.add(new Card(y, "Spade"));
                } else if (x == 3){
                    deck.add(new Card(y, "Heart"));
                }
            }
        }
    }

    public static void printDeck(){
        for (int x = 0; x < deck.size(); x++){
            if (deck.get(x).getNum() == 11){
                System.out.println("Jack of " + deck.get(x).getSuit() + "s");
            } else if (deck.get(x).getNum() == 12){
                System.out.println("Queen of " + deck.get(x).getSuit() + "s");
            } else if (deck.get(x).getNum() == 13){
                System.out.println("King of " + deck.get(x).getSuit() + "s");
            } else {
                System.out.println(deck.get(x).getNum() + " of " + deck.get(x).getSuit() + "s");
            }
        }
    }

    public void createPlayers(){
        Player computer1 = new Player("computer1");
        Player computer2 = new Player("computer2");
        Player computer3 = new Player("computer3");

    }

}
