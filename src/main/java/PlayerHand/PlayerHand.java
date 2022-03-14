package PlayerHand;

import PlayingCard.PlayingCard;

import java.util.ArrayList;

public class PlayerHand {
    public int numberOfCards;
    public ArrayList<PlayingCard> hand;

    public PlayerHand(ArrayList<PlayingCard> hand){
        this.hand=hand;
    }
}
