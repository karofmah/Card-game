package PlayerHand;

import PlayingCard.PlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerHand {
    public ArrayList<PlayingCard> hand;

    public PlayerHand(ArrayList<PlayingCard> hand){
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
        return hand.stream().allMatch(s->s.getSuit()=='S'||s.getSuit()=='H'||s.getSuit()=='D'||s.getSuit()=='C');
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

