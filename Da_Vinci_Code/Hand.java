public class Hand extends CardCollection{
    public Hand(String label){
        super(label);
    }
    public void display(){
        System.out.println(getLabel() + ": ");
        for(int i = 0; i < this.cards.size(); i++){
            System.out.println((i+1) + " " + getCard(i));
        }
        System.out.println();
    }
}
