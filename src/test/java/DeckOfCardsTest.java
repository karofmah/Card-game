import cardgame.model.DeckOfCards;
import cardgame.model.HandOfCards;
import cardgame.model.PlayingCard;
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
        System.out.println(hand.getHand().toString());
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
            for (PlayingCard card : hand.cardsOfHearts()) {
                System.out.println(card.toString());
                assertEquals('H', card.getSuit());
            }
        }

        @Test
        @DisplayName("Tests if existing queen of spades is detected in hand")
        public void queenOfSpadesExists() {
            hand.addNewCard(new PlayingCard('S',12));
            System.out.println(hand.getHand());
            assertTrue(hand.queenOfSpades());
        }
        @Test
        @DisplayName("Tests if a missing queen of spades is detected in hand")
        public void queenOfSpadesDoesNotExist(){
            PlayingCard card=new PlayingCard('S',12);
                hand.removeCard('S',12);
                System.out.println(hand.getHand());
                assertFalse(hand.queenOfSpades());


        }
        @Test
        @DisplayName("Tests if all cards in a hand are of the same suit")
        public void flushExists() {
            hand.getHand().clear();
            PlayingCard card=new PlayingCard('S',1);
            PlayingCard card1=new PlayingCard('S',2);
            PlayingCard card2=new PlayingCard('S',3);
            PlayingCard card3=new PlayingCard('S',4);
            PlayingCard card4=new PlayingCard('S',5);
            hand.addNewCard(card);
            hand.addNewCard(card1);
            hand.addNewCard(card2);
            hand.addNewCard(card3);
            hand.addNewCard(card4);

            System.out.println(hand.getHand());
            assertTrue(hand.flush());

        }
        @Test
        public void flushDoesNotExist(){
            hand.getHand().clear();
            PlayingCard card=new PlayingCard('S',1);
            PlayingCard card1=new PlayingCard('H',2);
            PlayingCard card2=new PlayingCard('D',3);
            PlayingCard card3=new PlayingCard('C',4);
            PlayingCard card4=new PlayingCard('S',5);
            hand.addNewCard(card);
            hand.addNewCard(card1);
            hand.addNewCard(card2);
            hand.addNewCard(card3);
            hand.addNewCard(card4);

            System.out.println(hand.getHand());
            assertFalse(hand.flush());
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
