import sun.lwawt.macosx.CSystemTray;

import java.util.ArrayList;
import java.util.Scanner;

public class EuchreGame {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        addCards();
        gameSetup();
        while (player.getHandSize() > 0) {
            currentTrick.clear();
            System.out.print("Your hand: ");
            player.printHand();
            playATrick();
            System.out.println(team1.getTricksTaken() + " " + team2.getTricksTaken());
            System.out.println("");
        }
    }

    static ArrayList<Card> deck = new ArrayList<>();
    static Card trumpCard;
    static Player computer1 = new Player("computer1");
    static Player computer2 = new Player("computer2");
    static Player computer3 = new Player("computer3");
    static Player player = new Player("player");
    static ArrayList<Card> currentTrick = new ArrayList<>();
    static Team team1 = new Team(computer1, computer3);
    static Team team2 = new Team(computer2, player);

    public static void addCards() {
        if (!deck.isEmpty()) {
            deck.subList(0, deck.size()).clear();
        }
        for (int x = 0; x < 4; x++) {
            for (int y = 9; y <= 14; y++) {
                if (x == 0) {
                    deck.add(new Card(Integer.toString(y), "Club"));
                } else if (x == 1) {
                    deck.add(new Card(Integer.toString(y), "Diamond"));
                } else if (x == 2) {
                    deck.add(new Card(Integer.toString(y), "Spade"));
                } else if (x == 3) {
                    deck.add(new Card(Integer.toString(y), "Heart"));
                }
            }
        }
    }

    public static void printDeck() {
        for (Card card : deck) {
            System.out.print(card.getCard() + ", ");
        }
        System.out.println("");
    }

    public static void gameSetup() {
        int dealer = (int) (Math.random() * 4) + 1;
        if (dealer == 1) {
            computer2.setLead(true);
            computer1.setSeat(0);
            computer2.setSeat(1);
            computer3.setSeat(2);
            player.setSeat(3);
        } else if (dealer == 2) {
            computer3.setLead(true);
            computer1.setSeat(3);
            computer2.setSeat(0);
            computer3.setSeat(1);
            player.setSeat(2);
        } else if (dealer == 3) {
            player.setLead(true);
            computer1.setSeat(2);
            computer2.setSeat(3);
            computer3.setSeat(0);
            player.setSeat(1);
        } else if (dealer == 4) {
            computer1.setLead(true);
            computer1.setSeat(1);
            computer2.setSeat(2);
            computer3.setSeat(3);
            player.setSeat(0);
        }


        for (int y = 1; y <= 4; y++) {
            for (int x = 0; x < 5; x++) {
                if (y == 1) {
                    computer1.addCardToHand(deck.remove((int) (Math.random() * deck.size())));
                } else if (y == 2) {
                    computer2.addCardToHand(deck.remove((int) (Math.random() * deck.size())));
                } else if (y == 3) {
                    computer3.addCardToHand(deck.remove((int) (Math.random() * deck.size())));
                } else if (y == 4) {
                    player.addCardToHand(deck.remove((int) (Math.random() * deck.size())));
                }
            }
        }
        trumpCard = deck.get(deck.size() - 1);

        for (Card card : player.getHand()) {
            if (card.getSuit().equals(trumpCard.getSuit()) && card.getActualNum() == 11) {
                card.setRight(true);
                System.out.println(card.getNum() + " " + card.getSuit());
            } else if (trumpCard.getSuit().equals("Club") && card.getSuit().equals("Spade") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Diamond") && card.getSuit().equals("Heart") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Spade") && card.getSuit().equals("Club") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Heart") && card.getSuit().equals("Diamond") && card.getActualNum() == 11) {
                card.setLeft(true);
            }
        }
        for (Card card : computer1.getHand()) {
            if (card.getSuit().equals(trumpCard.getSuit()) && card.getActualNum() == 11) {
                card.setRight(true);
                System.out.println(card.getNum() + " " + card.getSuit());
            } else if (trumpCard.getSuit().equals("Club") && card.getSuit().equals("Spade") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Diamond") && card.getSuit().equals("Heart") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Spade") && card.getSuit().equals("Club") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Heart") && card.getSuit().equals("Diamond") && card.getActualNum() == 11) {
                card.setLeft(true);
            }
        }
        for (Card card : computer2.getHand()) {
            if (card.getSuit().equals(trumpCard.getSuit()) && card.getActualNum() == 11) {
                card.setRight(true);
                System.out.println(card.getNum() + " " + card.getSuit());
            } else if (trumpCard.getSuit().equals("Club") && card.getSuit().equals("Spade") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Diamond") && card.getSuit().equals("Heart") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Spade") && card.getSuit().equals("Club") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Heart") && card.getSuit().equals("Diamond") && card.getActualNum() == 11) {
                card.setLeft(true);
            }
        }
        for (Card card : computer3.getHand()) {
            if (card.getSuit().equals(trumpCard.getSuit()) && card.getActualNum() == 11) {
                card.setRight(true);
                System.out.println(card.getNum() + " " + card.getSuit());
            } else if (trumpCard.getSuit().equals("Club") && card.getSuit().equals("Spade") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Diamond") && card.getSuit().equals("Heart") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Spade") && card.getSuit().equals("Club") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Heart") && card.getSuit().equals("Diamond") && card.getActualNum() == 11) {
                card.setLeft(true);
            }
        }
        for (Card card : deck) {
            if (card.getSuit().equals(trumpCard.getSuit()) && card.getActualNum() == 11) {
                card.setRight(true);
                System.out.println(card.getNum() + " " + card.getSuit());
            } else if (trumpCard.getSuit().equals("Club") && card.getSuit().equals("Spade") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Diamond") && card.getSuit().equals("Heart") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Spade") && card.getSuit().equals("Club") && card.getActualNum() == 11) {
                card.setLeft(true);
            } else if (trumpCard.getSuit().equals("Heart") && card.getSuit().equals("Diamond") && card.getActualNum() == 11) {
                card.setLeft(true);
            }
        }
    }

    public static boolean isTeamTaking() {
        System.out.println("1");
        if (currentTrick.size() == 2) {
            System.out.println("2");
            if (currentTrick.get(1).isRight()){
                System.out.println("18");
                return false;
            } else if (currentTrick.get(0).isRight()){
                System.out.println("19");
                return true;
            } else if (currentTrick.get(0).isLeft()){
                System.out.println("20");
                return true;
            }  else if (currentTrick.get(1).isLeft()){
                System.out.println("21");
                return false;
            } else if (currentTrick.get(1).getSuit().equals(currentTrick.get(0).getSuit()) && currentTrick.get(0).getActualNum() > currentTrick.get(1).getActualNum()) {
                System.out.println("3");
                return true;
            } else if (currentTrick.get(1).getSuit().equals(currentTrick.get(0).getSuit()) && currentTrick.get(0).getActualNum() < currentTrick.get(1).getActualNum()) {
                System.out.println("4");
                return false;
            } else if (currentTrick.get(1).getSuit().equals(trumpCard.getSuit()) && !currentTrick.get(0).getSuit().equals(trumpCard.getSuit())) {
                System.out.println("5");
                return false;
            } else if (!currentTrick.get(0).getSuit().equals(currentTrick.get(1).getSuit()) && !currentTrick.get(1).getSuit().equals(trumpCard.getSuit())) {
                System.out.println("6");
                return true;
            } else {
                System.out.println("7");
                return false;
            }
        } else if (currentTrick.size() > 2) {
            System.out.println("8");
            if (currentTrick.get(0).isRight() || currentTrick.get(2).isRight()){
                System.out.println("17");
                return false;
            } else if (currentTrick.get(1).isRight()){
                System.out.println("22");
                return true;
            } else if (currentTrick.get(0).isLeft() || currentTrick.get(2).isLeft()){
                System.out.println("23");
                return false;
            } else if (currentTrick.get(1).isLeft()){
                System.out.println("24");
                return true;
            } else if (currentTrick.get(1).getSuit().equals(currentTrick.get(0).getSuit()) && currentTrick.get(2).getSuit().equals(currentTrick.get(0).getSuit())){
                System.out.println("25");
                if (currentTrick.get(1).getActualNum() < currentTrick.get(0).getActualNum() || currentTrick.get(1).getActualNum() < currentTrick.get(2).getActualNum()) {
                    System.out.println("10");
                    return false;
                } else {
                    System.out.println("16");
                    return true;
                }
            } else if (currentTrick.get(1).getSuit().equals(currentTrick.get(0).getSuit()) && !currentTrick.get(2).getSuit().equals(currentTrick.get(0).getSuit())){
                System.out.println(26);
                if (currentTrick.get(1).getActualNum() < currentTrick.get(0).getActualNum()){
                    System.out.println("10");
                    return false;
                } else {
                    System.out.println("16");
                    return true;
                }
            } else if (currentTrick.get(1).getSuit().equals(trumpCard.getSuit()) && !currentTrick.get(0).getSuit().equals(trumpCard.getSuit()) && !currentTrick.get(2).getSuit().equals(trumpCard.getSuit())) {
                System.out.println("11");
                return true;
            } else if (currentTrick.get(0).getSuit().equals(trumpCard.getSuit()) || currentTrick.get(2).getSuit().equals(trumpCard.getSuit()) && !currentTrick.get(1).getSuit().equals(trumpCard.getSuit())) {
                System.out.println("12");
                return false;
            } else if (!currentTrick.get(1).getSuit().equals(currentTrick.get(0).getSuit()) && !currentTrick.get(1).getSuit().equals(trumpCard.getSuit())) {
                System.out.println("15");
                return false;
            } else {
                System.out.println("13");
                return false;
            }
        } else {
            System.out.println("14");
            return false;
        }
    }



    public static void playATrick(){
        int whoTook = 0;
        System.out.println("Trump is " + trumpCard.getSuit() + "s");
        if (computer1.isLead()){
            System.out.println("computer1 played " + computerPlayACard(computer1).getCard());
            System.out.println("computer2 played " + computerPlayACard(computer2).getCard());
            System.out.println("computer3 played " + computerPlayACard(computer3).getCard());
            playerPlayACard();
            boolean rightOrLeft = false;
            for (int x = 0; x < currentTrick.size(); x++){
                if (currentTrick.get(x).isRight()){
                    rightOrLeft = true;
                    whoTook = x;
                    break;
                }
            }
            if (!rightOrLeft) {
                for (int x = 0; x < currentTrick.size(); x++) {
                    if (currentTrick.get(x).isLeft()) {
                        whoTook = x;
                        rightOrLeft = true;
                        break;
                    }
                }
            }
            if (!rightOrLeft) {
                int currentLargest = 0;
                for (int x = 1; x < currentTrick.size(); x++) {
                    if (currentTrick.get(x).getSuit().equals(trumpCard.getSuit())){
                        if (currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit()) && currentTrick.get(x).getActualNum() > currentTrick.get(currentLargest).getActualNum()){
                            currentLargest = x;
                        } else if (!currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit())){
                            currentLargest = x;
                        }
                    }else if (currentTrick.get(x).getSuit().equals(currentTrick.get(0).getSuit()) && currentTrick.get(x).getActualNum() > currentTrick.get(currentLargest).getActualNum() && !currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit())){
                        currentLargest = x;
                    }
                }
                whoTook = currentLargest;
            }
            if (whoTook == 0){
                computer1.addTricksTaken();
                team1.addTricksTaken();
            } else if (whoTook == 1){
                computer2.addTricksTaken();
                team2.addTricksTaken();
                computer1.setLead(false);
                computer2.setLead(true);
            } else if (whoTook == 2){
                computer3.addTricksTaken();
                team1.addTricksTaken();
                computer1.setLead(false);
                computer3.setLead(true);
            } else if (whoTook == 3){
                player.addTricksTaken();
                team2.addTricksTaken();
                computer1.setLead(false);
                player.setLead(true);
            }
        } else if (computer2.isLead()){
            System.out.println("computer2 played " + computerPlayACard(computer2).getCard());
            System.out.println("computer3 played " + computerPlayACard(computer3).getCard());
            playerPlayACard();
            System.out.println("computer1 played " + computerPlayACard(computer1).getCard());
            boolean rightOrLeft = false;
            for (int x = 0; x < currentTrick.size(); x++){
                if (currentTrick.get(x).isRight()){
                    rightOrLeft = true;
                    whoTook = x;
                    break;
                }
            }
            if (!rightOrLeft) {
                for (int x = 0; x < currentTrick.size(); x++) {
                    if (currentTrick.get(x).isLeft()) {
                        whoTook = x;
                        rightOrLeft = true;
                        break;
                    }
                }
            }
            if (!rightOrLeft) {
                int currentLargest = 0;
                for (int x = 1; x < currentTrick.size(); x++) {
                    if (currentTrick.get(x).getSuit().equals(trumpCard.getSuit())){
                        if (currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit()) && currentTrick.get(x).getActualNum() > currentTrick.get(currentLargest).getActualNum()){
                            currentLargest = x;
                        } else if (!currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit())){
                            currentLargest = x;
                        }
                    }else if (currentTrick.get(x).getSuit().equals(currentTrick.get(0).getSuit()) && currentTrick.get(x).getActualNum() > currentTrick.get(currentLargest).getActualNum() && !currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit())){
                        currentLargest = x;
                    }
                }
                whoTook = currentLargest;
            }
            if (whoTook == 0){
                computer2.addTricksTaken();
                team2.addTricksTaken();
            } else if (whoTook == 1){
                computer3.addTricksTaken();
                team1.addTricksTaken();
                computer2.setLead(false);
                computer3.setLead(true);
            } else if (whoTook == 2){
                player.addTricksTaken();
                team2.addTricksTaken();
                computer2.setLead(false);
                player.setLead(true);
            } else if (whoTook == 3){
                computer1.addTricksTaken();
                team1.addTricksTaken();
                computer2.setLead(false);
                computer1.setLead(true);
            }
        } else if (computer3.isLead()){
            System.out.println("computer3 played " + computerPlayACard(computer3).getCard());
            playerPlayACard();
            System.out.println("computer1 played " + computerPlayACard(computer1).getCard());
            System.out.println("computer2 played " + computerPlayACard(computer2).getCard());
            boolean rightOrLeft = false;
            for (int x = 0; x < currentTrick.size(); x++){
                if (currentTrick.get(x).isRight()){
                    rightOrLeft = true;
                    whoTook = x;
                    break;
                }
            }
            if (!rightOrLeft) {
                for (int x = 0; x < currentTrick.size(); x++) {
                    if (currentTrick.get(x).isLeft()) {
                        whoTook = x;
                        rightOrLeft = true;
                        break;
                    }
                }
            }
            if (!rightOrLeft) {
                int currentLargest = 0;
                for (int x = 1; x < currentTrick.size(); x++) {
                    if (currentTrick.get(x).getSuit().equals(trumpCard.getSuit())){
                        if (currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit()) && currentTrick.get(x).getActualNum() > currentTrick.get(currentLargest).getActualNum()){
                            currentLargest = x;
                        } else if (!currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit())){
                            currentLargest = x;
                        }
                    }else if (currentTrick.get(x).getSuit().equals(currentTrick.get(0).getSuit()) && currentTrick.get(x).getActualNum() > currentTrick.get(currentLargest).getActualNum() && !currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit())){
                        currentLargest = x;
                    }
                }
                whoTook = currentLargest;
            }
            if (whoTook == 0){
                computer3.addTricksTaken();
                team1.addTricksTaken();
            } else if (whoTook == 1){
                player.addTricksTaken();
                team2.addTricksTaken();
                computer3.setLead(false);
                player.setLead(true);
            } else if (whoTook == 2){
                computer1.addTricksTaken();
                team1.addTricksTaken();
                computer3.setLead(false);
                computer1.setLead(true);
            } else if (whoTook == 3){
                computer2.addTricksTaken();
                team2.addTricksTaken();
                computer3.setLead(false);
                computer2.setLead(true);
            }
        } else if (player.isLead()){
            System.out.println("It is your lead");
            playerPlayACard();
            System.out.println("computer1 played " + computerPlayACard(computer1).getCard());
            System.out.println("computer2 played " + computerPlayACard(computer2).getCard());
            System.out.println("computer3 played " + computerPlayACard(computer3).getCard());
            boolean rightOrLeft = false;
            for (int x = 0; x < currentTrick.size(); x++){
                if (currentTrick.get(x).isRight()){
                    rightOrLeft = true;
                    whoTook = x;
                    break;
                }
            }
            if (!rightOrLeft) {
                for (int x = 0; x < currentTrick.size(); x++) {
                    if (currentTrick.get(x).isLeft()) {
                        whoTook = x;
                        rightOrLeft = true;
                        break;
                    }
                }
            }
            if (!rightOrLeft) {
                int currentLargest = 0;
                for (int x = 1; x < currentTrick.size(); x++) {
                    if (currentTrick.get(x).getSuit().equals(trumpCard.getSuit())){
                        if (currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit()) && currentTrick.get(x).getActualNum() > currentTrick.get(currentLargest).getActualNum()){
                            currentLargest = x;
                        } else if (!currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit())){
                            currentLargest = x;
                        }
                    }else if (currentTrick.get(x).getSuit().equals(currentTrick.get(0).getSuit()) && currentTrick.get(x).getActualNum() > currentTrick.get(currentLargest).getActualNum() && !currentTrick.get(currentLargest).getSuit().equals(trumpCard.getSuit())){
                        currentLargest = x;
                    }
                }
                whoTook = currentLargest;
            }
            if (whoTook == 0){
                player.addTricksTaken();
                team2.addTricksTaken();
            } else if (whoTook == 1){
                computer1.addTricksTaken();
                team1.addTricksTaken();
                player.setLead(false);
                computer1.setLead(true);
            } else if (whoTook == 2){
                computer2.addTricksTaken();
                team2.addTricksTaken();
                player.setLead(false);
                computer2.setLead(true);
            } else if (whoTook == 3){
                computer3.addTricksTaken();
                team1.addTricksTaken();
                player.setLead(false);
                computer3.setLead(true);
            }
        }
    }

    public static Card computerPlayACard(Player computer){
//        computer.printHand();
        int cardPlayed;
        boolean canFollow = false;
//        System.out.println("1");
        if (currentTrick.isEmpty()){
//            System.out.println("2");
            cardPlayed = (int) (Math.random() * computer.getHandSize());
            currentTrick.add(computer.removeCardFromHand(cardPlayed));
        } else if (!currentTrick.isEmpty()) {
//            System.out.println("3");
            if (currentTrick.get(0).isLeft()){
                String suitToFollow = trumpCard.getSuit();
                for (Card card : computer.getHand()) {
                    if (card.getSuit().equals(suitToFollow)) {
                        canFollow = true;
                    }
                }
                if (canFollow) {
                    cardPlayed = (int) (Math.random() * computer.getHandSize());
                    while (!computer.getCardInHand(cardPlayed).getSuit().equals(suitToFollow)) {
//                    System.out.println("4");
                        cardPlayed = (int) (Math.random() * computer.getHandSize());
                    }
//                System.out.println("5");
                    currentTrick.add(computer.removeCardFromHand((cardPlayed)));
                } else if (!canFollow){
//                System.out.println("6");
                    cardPlayed = (int) (Math.random() * computer.getHandSize());
                    currentTrick.add(computer.removeCardFromHand((cardPlayed)));
                }
            } else {
                for (Card card : computer.getHand()) {
                    if (card.getSuit().equals(currentTrick.get(0).getSuit())) {
                        canFollow = true;
                    }
                }
                cardPlayed = (int) (Math.random() * computer.getHandSize());
                if (computer.getCardInHand(cardPlayed).isLeft() && !currentTrick.get(0).getSuit().equals(trumpCard.getSuit())) {
                    if (!canFollow) {
                        currentTrick.add(computer.getCardInHand(cardPlayed));
                    }
                } else if (canFollow) {
                    cardPlayed = (int) (Math.random() * computer.getHandSize());
                    while (!computer.getCardInHand(cardPlayed).getSuit().equals(currentTrick.get(0).getSuit())) {
//                    System.out.println("4");
                        cardPlayed = (int) (Math.random() * computer.getHandSize());
                    }
//                System.out.println("5");
                    currentTrick.add(computer.removeCardFromHand((cardPlayed)));
                } else if (!canFollow) {
//                System.out.println("6");
                    cardPlayed = (int) (Math.random() * computer.getHandSize());
                    currentTrick.add(computer.removeCardFromHand((cardPlayed)));
                }
            }
        }
//        System.out.println("7");
        return currentTrick.get(currentTrick.size() - 1);
    }

    public static void playerPlayACard(){
        while (true) {
            System.out.println("Your team is taking: " + isTeamTaking());
            System.out.println("What card would you like to play?");
            int cardIndex = input.nextInt();
            if (currentTrick.isEmpty()) {
                currentTrick.add(player.removeCardFromHand(cardIndex));
                break;
            } else if (!currentTrick.isEmpty()) {
                if (currentTrick.get(0).isLeft()){
                    String suitToFollow = trumpCard.getSuit();
                    boolean canFollow = false;
                    if (player.getCardInHand(cardIndex).getSuit().equals(suitToFollow)){
                        currentTrick.add(player.removeCardFromHand(cardIndex));
                        break;
                    } else {
                        for (Card card : player.getHand()) {
                            if (card.getSuit().equals(suitToFollow)) {
                                canFollow = true;
                            }
                        }
                        if (!canFollow) {
                            currentTrick.add(player.removeCardFromHand(cardIndex));
                            break;
                        } else if (canFollow) {
                            System.out.println("You must follow suit! Trump is " + trumpCard.getSuit() + "s Pick another card");
                        }
                    }
                } else {
                    boolean canFollow = false;
                    if (player.getCardInHand(cardIndex).isLeft() && !currentTrick.get(0).getSuit().equals(trumpCard.getSuit())) {
                        for (Card card : player.getHand()) {
                            if (card.getSuit().equals(currentTrick.get(0).getSuit()) && !card.isLeft()) {
                                canFollow = true;
                                break;
                            }
                        }
                        if (!canFollow) {
                            currentTrick.add(player.removeCardFromHand(cardIndex));
                            break;
                        } else if (canFollow) {
                            System.out.println("You must follow suit! Trump is " + trumpCard.getSuit() + "s Pick another card");
                        }
                    } else if (player.getCardInHand((cardIndex)).isLeft() && currentTrick.get(0).getSuit().equals(trumpCard.getSuit())) {
                        currentTrick.add(player.removeCardFromHand(cardIndex));
                        break;
                    } else if (player.getCardInHand(cardIndex).getSuit().equals(currentTrick.get(0).getSuit())) {
                        currentTrick.add(player.removeCardFromHand(cardIndex));
                        break;
                    } else {
                        for (Card card : player.getHand()) {
                            if (card.getSuit().equals(currentTrick.get(0).getSuit())) {
                                canFollow = true;
                            }
                        }
                        if (!canFollow) {
                            currentTrick.add(player.removeCardFromHand(cardIndex));
                            break;
                        } else if (canFollow) {
                            System.out.println("You must follow suit! Trump is " + trumpCard.getSuit() + "s Pick another card");
                        }
                    }
                }
            }
        }
    }
}
