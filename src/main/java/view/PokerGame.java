package view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import viewcontroller.PokerGameController;
import javafx.application.Application;
import javafx.scene.layout.VBox;
import viewcontroller.GameState;

/**
 * @author agedi3
 * @version 1.0
 */
public class PokerGame extends Application {

    private static Stage primaryStage;
    private PokerGameController control;
    private GameScreen gameScreen;
    private ControlPane controlPane;
    private Console console;
    private VBox vBox;

    /**
     * this method is called upon running/launching the application
     * this method should display a scene on the stage
     * @param ps The primary Stage
     */
    // @Override
    public void start(Stage ps) {
        primaryStage = ps;
        StartScreen startScreen = new StartScreen(this);
        Scene scene = new Scene(startScreen.getPane(), 725, 500);
        primaryStage.setTitle("Extreme Poker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Starts the Game
     * This is called by StartScreen whenever it is done and the GameScreen,
     * ControlPane, and Console should be displayed
     * @param name The name of the human player
     * @param startAmount the start amount of chips
     */
    public void startGame(String name, int startAmount) {
        control = new PokerGameController(this, name, startAmount);
        gameScreen = new GameScreen(control);
        controlPane = new ControlPane(control);
        console = new Console();
        vBox = new VBox();

        vBox.getChildren().add(gameScreen);
        vBox.getChildren().add(controlPane);
        vBox.getChildren().add(console);

        primaryStage.getScene().setRoot(vBox);
        primaryStage.show();
        control.start();


    }

    /**
     * This is called by PokerGameController whenever updates are made. You
     * must handle updating the UI here.
     */
    public void updatesMade() {

        if (control.getState() == GameState.DONE) {
            gameScreen.endOfRound();
            controlPane.endOfRound();
            // console.clear();
        }
        if (control.getState() == GameState.AI_BET) {
            controlPane.getRaise().setDisable(true);
            controlPane.getCall().setDisable(true);
            controlPane.getFold().setDisable(true);
            // controlPane.getNewRound().setVisible(false);
            gameScreen.updatesMade();
        }
        if (control.getState() == GameState.HUMAN_BET) {
            gameScreen.updatesMade();
            controlPane.playerTurn();
        }

    }
    /**
    * @return vBox the vBox pane
    */
    public VBox getVBox() {
        return vBox;
    }

    /**
    * @return console the console
    */
    public Console getConsole() {
        return console;
    }

    /**
    * @return controlPane the control pane at the bottom
    */
    public ControlPane getControlPane() {
        return controlPane;
    }
    /**
    * @return gameScreen the game screen
    */
    public GameScreen getGameScreen() {
        return gameScreen;
    }

    /**
    * @return control the poker game controller
    */
    public PokerGameController getPokerGameController() {
        return control;
    }

    /**
    * @return primaryStage the main stage of the game
    */
    public Stage getStage() {
        return primaryStage;
    }
    /**
     * This is the main method that launches the javafx application
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}