package HandOfCards;

import PlayingCard.PlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards {
    public ArrayList<PlayingCard> hand;

    public HandOfCards(ArrayList<PlayingCard> hand){
        this.hand=hand;
    }

    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    public int sumOfTheFaces() {
        int sumOfFaces= hand.stream().map(PlayingCard::getFace).reduce((a,b)->a+b).get();
        return sumOfFaces;
    }
    public List<PlayingCard> cardOfHearts(){
        List<PlayingCard> cardsOfHearts= hand.stream().filter(p->p.getSuit()=='H').collect(Collectors.toList());
        return cardsOfHearts;
    }
    public boolean queenOfSpades(){
        return hand.stream().anyMatch(p -> p.getSuit()=='S') && hand.stream().anyMatch(p -> p.getFace()==12);
    }
    public boolean flush(){
        return hand.stream().distinct().anyMatch(p->getSize()==1);//Alternativ løsning
    }
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

