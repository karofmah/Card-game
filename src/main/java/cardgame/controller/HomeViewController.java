/**
 * Sample Skeleton for 'homeView.fxml' Controller Class
 */

package cardgame.controller;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="checkHandBtn"
    private Button checkHandBtn; // Value injected by FXMLLoader

    @FXML // fx:id="dealHandBtn"
    private Button dealHandBtn; // Value injected by FXMLLoader

    @FXML
    public void checkHandBtnClicked(javafx.event.ActionEvent event) {

    }

    @FXML
    public void dealHandBtnClicked(javafx.event.ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert checkHandBtn != null : "fx:id=\"checkHandBtn\" was not injected: check your FXML file 'homeView.fxml'.";
        assert dealHandBtn != null : "fx:id=\"dealHandBtn\" was not injected: check your FXML file 'homeView.fxml'.";

    }


}
