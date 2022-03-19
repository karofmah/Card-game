package HandOfCards;

import PlayingCard.PlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards {
    public ArrayList<PlayingCard> hand;

    /**
     * Creates a constructor for HandOfCards
     * @param hand of cards, can not be empty
     */
    public HandOfCards(ArrayList<PlayingCard> hand){
        this.hand=hand;
        if(hand.isEmpty()){
            throw new IllegalArgumentException("This hand has no cards. Deal hand from deck");
        }
    }

    /**
     * Return hand of cards
     * @return hand as an ArrayList
     */
    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    /**
     * Calculates the sum of faces in hand
     * @return sumOfFaces as an int
     */
    public int sumOfTheFaces() {
        int sumOfFaces= hand.stream().map(PlayingCard::getFace).reduce((a,b)->a+b).get();
        return sumOfFaces;
    }

    /**
     * Returns cards with the suit of hearts in hand
     * @return cardOfHearts as a List
     */
    public List<PlayingCard> cardOfHearts(){
        List<PlayingCard> cardsOfHearts= hand.stream().filter(p->p.getSuit()=='H').collect(Collectors.toList());
        return cardsOfHearts;
    }

    /**
     * Checks if the hand has the card queen of spades
     * @return boolean (true or false)
     */
    public boolean queenOfSpades(){
        return hand.stream().anyMatch(p -> p.getSuit()=='S') && hand.stream().anyMatch(p -> p.getFace()==12);
    }

    /**
     * Checks if all cards in hand are of the same suit
     * @return boolean (true or false)
     */
    public boolean flush(){
        return hand.stream().distinct().anyMatch(p->getSize()==1);//Alternativ løsning
    }

    /**
     * Returns the number of cards in hand
     * @return
     */
    public int getSize(){
        return hand.size();
    }
    @Override
    public String toString() {
        return "PlayerHand{" +
                "hand=" + hand +
                '}';
    }
}

