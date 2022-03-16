import DeckOfCards.DeckOfCards;
import PlayerHand.PlayerHand;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
public class DeckOfCardsTest {

    @Test
    public void cardsAreDealt(){
        DeckOfCards deck=new DeckOfCards();
        PlayerHand hand=new PlayerHand(deck.dealHand(5));
        System.out.println(hand.getHand().toString());
    }

}
