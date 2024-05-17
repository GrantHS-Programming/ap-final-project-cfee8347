public class Card {

    private String num;
    private String suit;

    public Card(String num, String suit) {
        this.num = num;
        this.suit = suit;
    }

    public String getNum() {
        if (num.equals("11")){
            return "Jack";
        } else if (num.equals("12")){
            return "Queen";
        } else if (num.equals("13")){
            return "King";
        } else if(num.equals("14")){
            return "Ace";
        } else {
            return num;
        }
    }

    public String getSuit(){
        return suit;
    }

    public String getCard(){
        if (num.equals("11")){
            return "Jack of " + suit + "s";
        } else if (num.equals("12")){
            return "Queen of " + suit + "s";
        } else if (num.equals("13")){
            return "King of " + suit + "s";
        } else if(num.equals("14")){
            return "Ace of " + suit + "s";
        } else {
            return num + " of " + suit + "s";
        }
    }

    public int getActualNum(){
        return Integer.parseInt(num);
    }

}
