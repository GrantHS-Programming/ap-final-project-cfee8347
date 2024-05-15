import java.util.ArrayList;
import java.util.Scanner;

public class EuchreGame {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        addCards();
        printDeck();
        gameSetup();
    }

    static ArrayList<Card> deck = new ArrayList<>();
    static Card trumpCard;
    static Player computer1 = new Player();
    static Player computer2 = new Player();
    static Player computer3 = new Player();
    static Player player = new Player();
    static ArrayList<Card> currentTrick = new ArrayList<>();
    static Team team1 = new Team(computer1, computer3);
    static Team team2 = new Team (computer2, player);

    public static void addCards(){
        if (!deck.isEmpty()){
            deck.subList(0, deck.size()).clear();
        }
        for (int x = 0; x < 4; x++){
            for (int y = 9; y <= 14; y++){
                if (x == 0){
                    deck.add(new Card(Integer.toString(y), "Club"));
                } else if (x == 1){
                    deck.add(new Card(Integer.toString(y), "Diamond"));
                } else if (x == 2){
                    deck.add(new Card(Integer.toString(y), "Spade"));
                } else if (x == 3){
                    deck.add(new Card(Integer.toString(y), "Heart"));
                }
            }
        }
    }

    public static void printDeck(){
        for (int x = 0; x < deck.size(); x++){
            System.out.print(deck.get(x).getNum() + " of " + deck.get(x).getSuit() + "s, ");
        }
        System.out.println("");
    }

    public static void gameSetup(){
        int dealer = (int) (Math.random() * 4) + 1;
        if (dealer == 1){
            computer1.setDealer(true);
            computer1.setSeat(0);
            computer2.setSeat(1);
            computer3.setSeat(2);
            player.setSeat(3);
        } else if (dealer == 2){
            computer2.setDealer(true);
            computer1.setSeat(3);
            computer2.setSeat(0);
            computer3.setSeat(1);
            player.setSeat(2);
        } else if (dealer == 3){
            computer3.setDealer(true);
            computer1.setSeat(2);
            computer2.setSeat(3);
            computer3.setSeat(0);
            player.setSeat(1);
        } else if (dealer == 4){
            player.setDealer(true);
            computer1.setSeat(1);
            computer2.setSeat(2);
            computer3.setSeat(3);
            player.setSeat(0);
        }

        for (int y = 1; y <= 4; y++) {
            for (int x = 0; x < 5; x++) {
                if (y == 1){
                    computer1.addCardToHand(deck.remove((int) (Math.random() * deck.size())));
                } else if (y == 2){
                    computer2.addCardToHand(deck.remove((int) (Math.random() * deck.size())));
                } else if (y== 3){
                    computer3.addCardToHand(deck.remove((int) (Math.random() * deck.size())));
                } else if (y == 4){
                    player.addCardToHand(deck.remove((int) (Math.random() * deck.size())));
                }
            }
        }
        trumpCard = deck.get(deck.size() - 1);
    }

    public static void playATrick(){
        if (computer1.getSeat() == 1){
            computerPlayACard(computer1);
            computerPlayACard(computer2);
            computerPlayACard(computer3);
            playerPlayACard();
        } else if (computer2.getSeat() == 1){
            computerPlayACard(computer2);
            computerPlayACard(computer3);
            playerPlayACard();
            computerPlayACard(computer1);
        } else if (computer3.getSeat() == 1){
            computerPlayACard(computer3);
            playerPlayACard();
            computerPlayACard(computer1);
            computerPlayACard(computer2);
        } else if (player.getSeat() == 1){
            playerPlayACard();
            computerPlayACard(computer1);
            computerPlayACard(computer2);
            computerPlayACard(computer3);
        }
    }

    public static void computerPlayACard(Player computer){
        if (currentTrick.isEmpty()){
            int cardPlayed = (int) (Math.random() * computer.getHandSize());
            currentTrick.add(computer.removeCardFromHand(cardPlayed));
        } else if (!currentTrick.isEmpty()){
            int cardPlayed = (int) (Math.random() * computer.getHandSize());
            if (computer.getCardInHand(cardPlayed).getSuit().equals(currentTrick.get(0).getSuit())){
                currentTrick.add(computer.removeCardFromHand(cardPlayed));
            }
        }
    }

    public static void playerPlayACard(){
        while (true) {
            System.out.println("What card would you like to play?");
            int cardIndex = input.nextInt();
            if (currentTrick.isEmpty()) {
                currentTrick.add(player.removeCardFromHand(cardIndex));
            } else if (!currentTrick.isEmpty()) {
                if (player.getCardInHand(cardIndex).getSuit().equals(currentTrick.get(0).getSuit())) {
                    currentTrick.add(player.removeCardFromHand(cardIndex));
                    break;
                } else {
                    System.out.println("You have to follow suit! Pick a different card.");
                }
            }
        }
    }

}
