import java.util.Scanner;
public class Player {
    private String name;
    Hand hand;
    public Player(String name){
        this.name = name;
        this.hand = new Hand(name);
    }
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void selfDisplay(){
        this.hand.display();
    }
    public void oppoDisplay(){
        System.out.println(this.name);
        for(int i = 0; i < this.hand.cards.size(); i++){
            if(this.hand.getCard(i).beKnown){
                System.out.print(i+1 + " ");
                System.out.println(this.hand.getCard(i));
            }
            else{
                if(this.hand.getCard(i).color){
                    System.out.println(i+1 + " White ?");
                }
                else{
                    System.out.println(i+1 + " Black ?");
                }
            }
        }
    }
    public boolean lose(){
        for(int i = 0; i < this.hand.cards.size(); i++){
            if(!this.hand.getCard(i).beKnown){
                return false;
            }
        }
        return true;
    }
    public boolean guess(Player that, int i, int rank){
        clear();
        if (that.hand.getCard(i).equals(rank)){
            System.out.println("You are right!");
            that.hand.getCard(i).beKnown = true;
            return true;
        }
        else{
            System.out.println("You are wrong");
            return false;
        }
    }
    public void game(Player that, Deck deck){
        Scanner in = new Scanner(System.in);
        boolean success = false;
        boolean firstTime = true;
        do{
            this.selfDisplay();
            that.oppoDisplay();
            System.out.printf("It's %s's turn.\n", this.name);
            if(!firstTime){
                System.out.println("Enter 1 to guess and 0 to pass");
                int choice = in.nextInt();
                if(choice == 0){
                    clear();
                    break;
                }
                else if (choice == 1){
                    clear();
                    this.selfDisplay();
                    that.oppoDisplay();
                    deck.deal(this.hand, 1);
                    success = guess(that, in.nextInt()-1, in.nextInt());
                    if(!success){
                        this.hand.getCard(this.hand.cards.size()-1).beKnown = true;
                    }
                    else{
                        if(that.lose()){
                            System.out.printf("%s wins!", this.name);
                            System.exit(0);
                        }
                    }
                    this.hand.sort();
                }
            }
            else{
                deck.deal(this.hand, 1);
                success = guess(that, in.nextInt()-1, in.nextInt());
                firstTime = false;
                if(!success){
                    this.hand.getCard(this.hand.cards.size()-1).beKnown = true;
                }
                else{
                    if(that.lose()){
                        System.out.printf("%s wins!", this.name);
                        System.exit(0);
                    }
                }
                this.hand.sort();
            }
        }while(success);
    }
}
