public class Card {
    boolean color;
    int rank;
    boolean beKnown;
    public Card(boolean color, int rank){
        this.color = color;
        this.rank = rank;
        this.beKnown = false;
    }
    public String toString(){
        if(this.color){
            return ("white " + this.rank);
        }
        else{
            return ("Black " + this.rank);
        }
    }
    

    public boolean rankEqualsTo(int rank){
        int number = this.rank;
        if(number == rank){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean equals(int rank){
        if(this.rankEqualsTo(rank)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean biggerThan(Card that){
        if(this.rank > that.rank){
            return true;
        }
        else if(this.rank < that.rank){
            return false;
        }
        else{
            if(this.color){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public void known(Card card){
        card.beKnown = true;
    }
}

