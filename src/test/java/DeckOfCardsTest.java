import DeckOfCards.DeckOfCards;
import HandOfCards.HandOfCards;
import PlayingCard.PlayingCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class DeckOfCardsTest {

    private DeckOfCards deck;
    private HandOfCards hand;
    private ArrayList <PlayingCard> emptyList;
    @BeforeEach
    @DisplayName("Fills deck with cards, deals hand and creates an empty hand")
    public void setup(){
        this.deck=new DeckOfCards();
        this.hand=new HandOfCards(deck.dealHand(5));
        this.emptyList=new ArrayList<PlayingCard>();
    }

    @Nested
    class generalTest {
        @Test
        @DisplayName("Checks if the deck will lose, and the hand will gain, 5 cards when 5 cards are dealt")
        public void cardsAreDealtProperly() {
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
        public void checkCardOfHearts() {
            deck.dealHand(5);
            for (PlayingCard card : hand.cardOfHearts()) {
                System.out.println(card.toString());
                assertEquals('H', card.getSuit());
            }
        }

        @Test
        @DisplayName("Checks if queen of spades exists in a hand ")
        public void checkIfQueenOfSpadesExists() {
            for (PlayingCard card : hand.getHand()) {
                if (card.getSuit() == 'S' && card.getFace() == 12) {
                    assertTrue(hand.queenOfSpades());
                } else {
                    assertFalse(hand.queenOfSpades());
                }
            }
        }

        @Test
        @DisplayName("Check if all cards in a hand are of the same suit")
        public void checkFlush() {
            ArrayList<Character> suitsInHand = new ArrayList<Character>();
            for (Character c : suitsInHand) {
                if (!c.equals(suitsInHand.get(0)))
                    assertFalse(hand.flush());

                assertTrue(hand.flush());//Fix Test
            }
        }
    }
    @Nested
    class inputNotSupported{
        @Test
        @DisplayName("Checks if IllegalArgumentException is thrown if an empty hand is created")
        public void handIsEmpty(){
            assertThrows(IllegalArgumentException.class,()-> new HandOfCards(emptyList));
        }
    }
}
