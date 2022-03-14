package DeckOfCards;

import PlayingCard.PlayingCard;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<PlayingCard> deck;
    private final char[] suit = { 'S', 'H', 'D', 'C' };

    public DeckOfCards(ArrayList<PlayingCard> deck){
    deck=this.deck;
    }
    public ArrayList<PlayingCard> dealHand(int n){
        ArrayList<PlayingCard> cardsDealt=new ArrayList();
        for (int i = 0; i <= n; i++) {
            Random randomCardIndex=new java.util.Random();
            cardsDealt.add(deck.get(randomCardIndex.nextInt(52)));
        }
        return cardsDealt;
    }

}
