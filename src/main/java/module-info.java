module cardgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
    opens cardgame.controller to javafx.fxml;
    opens cardgame to javafx.fxml;
    exports cardgame.controller;
    exports cardgame;
    exports cardgame.model;


}