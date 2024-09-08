import java.util.ArrayList;
import java.util.Random;

public class CardCollection {
    private String label;
    ArrayList<Card> cards;

    public CardCollection(String label){
        this.label = label;
        this.cards = new ArrayList<Card>();
    }
    public String getLabel(){
        return this.label;
    }
    public void addCard(Card card){
        this.cards.add(card);
    }
    public Card popCard(){
        return cards.remove(this.cards.size()-1);
    }
    public void deal(CardCollection that, int n){
        for(int i = 0; i < n; i++){
            Card card = popCard();
            that.addCard(card);
        }
    }
    public Card getCard(int i){
        return this.cards.get(i);
    }
    public void swapCards(int i, int j){
        Card temp = this.cards.get(i);
        this.cards.set(i, this.cards.get(j));
        this.cards.set(j, temp);

    }
    public void shuffle(){
        Random random = new Random();
        for(int i = 1; i <= this.cards.size()-1; i++){
            int j = random.nextInt(i);
            swapCards(i, j);
        }
    }
    public void sort(){
        for(int i = 0; i < this.cards.size();i++){
            for(int j = 1; j < this.cards.size() - i; j++){
                if (this.getCard(j-1).biggerThan(this.getCard(j))){
                    swapCards(j-1, j);
                }
            }
        }
    }
}
