package cardgame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<PlayingCard> deck=new ArrayList<>();
    private final char[] suit = { 'S', 'H', 'D', 'C' };

    /**
     * Creates a constructor for the class DeckOfCards
     * which fills a deck with cards
     */
    public DeckOfCards(){
        for (char suits:suit) {
            for (int i = 1; i <14; i++) {
                deck.add(new PlayingCard(suits,i));
            }
        }

    }

    /**
     * Returns a list of the cards in hand that is dealt
     * @param n
     * @return cardsDealt as an ArrayList
     */
    public ArrayList<PlayingCard> dealHand(int n){
        ArrayList<PlayingCard> cardsDealt=new ArrayList();
        for (int i = 0; i < n; i++) {
            int randomCardIndex=new java.util.Random().nextInt(deck.size());
            cardsDealt.add(deck.get(randomCardIndex));
            deck.remove(deck.get(randomCardIndex));
        }
        return cardsDealt;
    }

    /**
     * Return number of cards in deck of cards
     * @return deck.size() as an int
     */
    public int getSize(){
        return deck.size();
    }

    public ArrayList<PlayingCard> getDeck(){
        return deck;
    }
    @Override
    public String toString() {
        return "DeckOfCards{" +
                "deck=" + deck +
                ", suit=" + Arrays.toString(suit) +
                '}';
    }
}
