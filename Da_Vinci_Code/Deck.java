public class Deck extends CardCollection{
    public Deck (String label){
        super(label);

        for(int rank = 0; rank <= 11; rank++){
            cards.add(new Card(true, rank));
            cards.add(new Card(false, rank));
        }
    }
    
}

