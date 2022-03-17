package DeckOfCards;

import PlayingCard.PlayingCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<PlayingCard> deck=new ArrayList<>();
    private final char[] suit = { 'S', 'H', 'D', 'C' };

    public DeckOfCards(){
        for (char suits:suit) {
            for (int i = 1; i <14; i++) {
                deck.add(new PlayingCard(suits,i));
            }
        }

    }

    public ArrayList<PlayingCard> dealHand(int n){
        ArrayList<PlayingCard> cardsDealt=new ArrayList();
        for (int i = 0; i < n; i++) {
            Random randomCardIndex=new java.util.Random();
            cardsDealt.add(deck.get(randomCardIndex.nextInt(deck.size())));
            deck.remove(deck.get(randomCardIndex.nextInt(deck.size())));
        }
        return cardsDealt;
    }
    public int getSize(){
        return deck.size();
    }
    @Override
    public String toString() {
        return "DeckOfCards{" +
                "deck=" + deck +
                ", suit=" + Arrays.toString(suit) +
                '}';
    }
}
