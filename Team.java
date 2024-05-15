public class Team {

    private Player teamMember1;
    private Player teamMember2;
    private int tricksTaken;

    public Team(Player one, Player two){
        teamMember1 = one;
        teamMember2 = two;
        tricksTaken = 0;
    }

    public void addTricksTaken(){
        tricksTaken += 1;
    }

    public void setTricksTaken(int tricksTaken){
        this.tricksTaken = tricksTaken;
    }

    public int getTricksTaken(){
        return tricksTaken;
    }

}
