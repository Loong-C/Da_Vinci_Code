import java.util.Scanner;
public class Da_Vinci_Code {
    public static int inputCardRank(){
        Scanner in = new Scanner(System.in);
        int rank = in.nextInt();
        return rank;
    }
    public static void main(String[] args){
        Deck deck = new Deck("Deck");
        deck.shuffle();
        Player player1 = new Player("Loong");
        Player player2 = new Player("Yoyo");
        deck.deal(player1.hand, 5);
        deck.deal(player2.hand, 5);
        while(!player1.lose() && !player2.lose()){
            player1.hand.sort();
            player2.hand.sort();
            player1.game(player2,deck);
            player2.game(player1,deck);
        }
    }
}