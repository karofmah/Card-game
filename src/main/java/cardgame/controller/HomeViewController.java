/**
 * Sample Skeleton for 'homeView.fxml' Controller Class
 */

package cardgame.controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import cardgame.model.DeckOfCards;
import cardgame.model.HandOfCards;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML
    public Label txtSumOfFaces;
    public Label txtQueenOfSpades;
    public Label txtCardOfHearts;
    public Label txtFlush;

    @FXML // fx:id="checkHandBtn"
    private Button checkHandBtn; // Value injected by FXMLLoader

    @FXML // fx:id="dealHandBtn"
    private Button dealHandBtn; // Value injected by FXMLLoader

    DeckOfCards deck;
    HandOfCards hand;
    @FXML
    public void checkHandBtnClicked(javafx.event.ActionEvent event) {

        txtCardOfHearts.setText(hand.cardsOfHearts().toString());
        txtQueenOfSpades.setText(Boolean.toString(hand.queenOfSpades()));
        txtSumOfFaces.setText(Integer.toString(hand.sumOfTheFaces()));
        txtFlush.setText(Boolean.toString(hand.flush()));
        System.out.println("Checked hand!");
    }

    @FXML
    public void dealHandBtnClicked(javafx.event.ActionEvent event) {
        hand=new HandOfCards(deck.dealHand(5));
        System.out.println("Dealt hand!");
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert checkHandBtn != null : "fx:id=\"checkHandBtn\" was not injected: check your FXML file 'homeView.fxml'.";
        assert dealHandBtn != null : "fx:id=\"dealHandBtn\" was not injected: check your FXML file 'homeView.fxml'.";
        deck=new DeckOfCards();
    }


}
