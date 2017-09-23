package view;

import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.Scene;
import java.util.Optional;


/**
 * @author agedi3
 * @version 1.0
 */
public class StartScreen extends StackPane {
    private Scene scene;
    private StackPane pane;
    private PokerGame cont;

    // Path to the image file for the background
    private static final String BACK_LOCATION = "File:./src/main/res"
        + "/poker-game-background.png";

    /**
     * StartScreen's constructor
     * @param cont The PokerGame to interact with
     */
    public StartScreen(PokerGame cont) {
        this.cont = cont;
        ImageView image = new ImageView(BACK_LOCATION);
        image.setFitHeight(500);
        image.setFitWidth(725);

        pane = new StackPane();

        Button button = new Button("Start Game!");
        button.setTranslateX(-225);
        button.setTranslateY(150);
        // HandlerClass handler1 = new HandlerClass();
        // button.setOnAction(handler1);

        button.setOnAction(event -> {
            // if(!dialog.isShowing()) {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("New Game");
                dialog.setHeaderText("Confirmation");
                dialog.setContentText("Enter your name:");
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    TextInputDialog chipsAmount = new TextInputDialog();
                    chipsAmount.setTitle("Chips");
                    chipsAmount.setHeaderText("Amount of Chips");
                    chipsAmount.setContentText("Set starting amount of chips ");
                    Optional<String> amount = chipsAmount.showAndWait();
                    if (amount.isPresent()) {
                        cont.startGame(result.get(),
                            Integer.parseInt(amount.get()));
                    }
                }
            });
        pane.getChildren().add(image);
        pane.getChildren().add(button);

    }

    /**
     *
     * @return pane a getter method for pane
     */
    public StackPane getPane() {
        return pane;
    }
}