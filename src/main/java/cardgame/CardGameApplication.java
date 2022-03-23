package cardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Application for Card game
 */
public class CardGameApplication extends Application {
    public static Stage stage;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        CardGameApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(CardGameApplication.class.getResource("homeView.fxml"));
        Scene scene = null;

        try {
            scene = new Scene(fxmlLoader.load(), 861, 672);
        } catch (IOException e) {
            logger.severe("ERROR: IOException occurred. Cause: " + e.getCause());
        }

        stage.setTitle("Card game");
        stage.setScene(scene);
        stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, windowEvent -> {
            //Since connection is kept as long as the app is running
            //Listen for closing event and close when at app exit

        });
        stage.show();

    }


}
