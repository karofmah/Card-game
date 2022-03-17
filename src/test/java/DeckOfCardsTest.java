import DeckOfCards.DeckOfCards;
import HandOfCards.HandOfCards;
import PlayingCard.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DeckOfCardsTest {

    private DeckOfCards deck;
    private HandOfCards hand;

    @BeforeEach
    public void setup(){
        this.deck=new DeckOfCards();
        this.hand=new HandOfCards(deck.dealHand(5));
    }

    @Test
    public void cardsAreDealtProperly(){
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
        for (PlayingCard card:hand.getHand()) {
            if(card.getSuit()=='S' && card.getFace()==12){
                assertTrue(hand.queenOfSpades());
            }else {
                assertFalse(hand.queenOfSpades());
            }
        }
    }


}
