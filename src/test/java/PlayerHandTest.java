import DeckOfCards.DeckOfCards;
import PlayerHand.PlayerHand;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
public class PlayerHandTest {

    @Test
    public void calculateSumOfTheFaces(){
        DeckOfCards deck=new DeckOfCards();
        PlayerHand hand=new PlayerHand(deck.dealHand(5));
        System.out.println(hand.sumOfTheFaces());//Assert Test
    }


}
