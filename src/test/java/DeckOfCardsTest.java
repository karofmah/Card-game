import DeckOfCards.DeckOfCards;
import HandOfCards.HandOfCards;
import PlayingCard.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class DeckOfCardsTest {

    private DeckOfCards deck;
    private HandOfCards hand;

    @BeforeEach
    @DisplayName("Fills deck with cards and deals hand")
    public void setup(){
        this.deck=new DeckOfCards();
        this.hand=new HandOfCards(deck.dealHand(5));
    }

    @Test
    @DisplayName("Checks if the deck will lose, and the hand will gain, 5 cards when 5 cards are dealt")
    public void cardsAreDealtProperly(){
        assertEquals(47, deck.getSize());
        assertEquals(5, hand.getSize());
    }

    @Test
    @DisplayName("Calculates the sum of faces in a hand ")
    public void calculateSumOfTheFaces() {
        deck.dealHand(5);
        int expectedSumOfFaces = 0;
        for (PlayingCard card : hand.getHand()) {
            expectedSumOfFaces += card.getFace();
        }
        assertEquals(expectedSumOfFaces, hand.sumOfTheFaces());
    }
    @Test
    @DisplayName("Checks if the list that represents cards of hearts, only contains cards with suit of hearts")
    public void checkCardOfHearts(){
        deck.dealHand(5);
        for (PlayingCard card:hand.cardOfHearts()) {
            assertEquals('H',card.getSuit());
        }
    }
    @Test
    @DisplayName("Checks if queen of spades exists in a hand ")
    public void checkIfQueenOfSpadesExists(){
        for (PlayingCard card:hand.getHand()) {
            if(card.getSuit()=='S' && card.getFace()==12){
                assertTrue(hand.queenOfSpades());
            }else {
                assertFalse(hand.queenOfSpades());
            }
        }
    }

    @Test
    public void checkFlush(){
        ArrayList<Character> suitsInHand=new ArrayList<Character>();
            for (Character c:suitsInHand) {
                if(!c.equals(suitsInHand.get(0)))
                    assertFalse(hand.flush());

            assertTrue(hand.flush());
        }


    }
}
