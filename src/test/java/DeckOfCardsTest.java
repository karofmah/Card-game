import DeckOfCards.DeckOfCards;
import PlayerHand.PlayerHand;
import PlayingCard.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DeckOfCardsTest {

    private DeckOfCards deck;
    private PlayerHand hand;

    @BeforeEach
    public void setup(){
        this.deck=new DeckOfCards();
        this.hand=new PlayerHand(deck.dealHand(5));
    }

    @Test
    public void cardsAreDealtProperly(){
        deck.dealHand(5);
        assertEquals(47, deck.getSize());
        assertEquals(5, hand.getSize());
    }

    @Test
    public void calculateSumOfTheFaces() {
        deck.dealHand(5);
        int expectedSumOfFaces = 0;
        for (PlayingCard card : hand.getHand()) {
            expectedSumOfFaces += card.getFace();
        }
        assertEquals(expectedSumOfFaces, hand.sumOfTheFaces());
    }
    @Test
    public void representCardOfHearts(){
        deck.dealHand(5);
        for (PlayingCard card:hand.cardOfHearts()) {
            assertEquals('H',card.getSuit());
        }
    }
    @Test
    public void queenOfSpadesExists(){
        deck.dealHand(5);
        for (PlayingCard card:hand.getHand()) {
            if(card.getSuit()=='S'){
                assertTrue(hand.queenOfSpades());
            }else {
                assertFalse(hand.queenOfSpades());
            }
        }
    }


}
