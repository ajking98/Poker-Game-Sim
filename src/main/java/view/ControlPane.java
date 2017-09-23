package view;

import javafx.scene.layout.HBox;
import viewcontroller.PokerGameController;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class ControlPane extends HBox {

    private PokerGameController cont;
    private Button raise;
    private Button call;
    private Button fold;
    private Button newRound;

    /**
     * Constructor for ControlPane
     * @param  cont The PokerGameController to interact with
     */
    public ControlPane(PokerGameController cont) {
        this.cont = cont;
        TextField textField = new TextField();
        raise = new Button("Raise");
        call = new Button("Call");
        fold = new Button("Fold");
        newRound =  new Button("Start new round");
        newRound.setVisible(false);

        String soundEff = "src/main/res/" + "shotgun.mp3";
        Media soundTune = new Media(new File(soundEff).toURI().toString());


        // textField.set
        this.getChildren().addAll(textField, raise, call, fold, newRound);

        HBox hBox = new HBox();
        ((HBox) this).setAlignment(Pos.CENTER);

        raise.setOnAction(event -> {
                if (!(textField.getText().length() == 0)) {
                    int raiseAmount = Integer.parseInt(textField.getText());
                    cont.humanBet(raiseAmount);
                    MediaPlayer mediaPLayer = new MediaPlayer(soundTune);
                    MediaPlayer.Status status = mediaPLayer.getStatus();
                    if (status != MediaPlayer.Status.PLAYING) {
                        mediaPLayer.play();
                    }
                }
            });

        raise.setDisable(true);

        call.setOnAction(event -> {
                cont.humanCall();
                MediaPlayer mediaPLayer = new MediaPlayer(soundTune);
                MediaPlayer.Status status = mediaPLayer.getStatus();
                if (status != MediaPlayer.Status.PLAYING) {
                    mediaPLayer.play();
                }
            });
        call.setDisable(true);

        fold.setOnAction(event -> {
                cont.humanFold();
                MediaPlayer mediaPLayer = new MediaPlayer(soundTune);
                MediaPlayer.Status status = mediaPLayer.getStatus();
                if (status != MediaPlayer.Status.PLAYING) {
                    mediaPLayer.play();
                }
            });
        fold.setDisable(true);

        newRound.setOnAction(event -> {
                cont.startNewPokerHand();
                newRound.setVisible(false);
                MediaPlayer mediaPLayer = new MediaPlayer(soundTune);
                MediaPlayer.Status status = mediaPLayer.getStatus();
                if (status != MediaPlayer.Status.PLAYING) {
                    mediaPLayer.play();
                }
                Console.clearLog();
                // board.startNewPokerHand();
            });

    }

    /**
     * Called whenever it becomes the player's turn again
     */
    // Change this later
    public void playerTurn() {

        raise.setDisable(false);
        call.setDisable(false);
        fold.setDisable(false);
        // newRound.setVisible(false);
    }

    /**
     * Method called when the round ends.
     */
    public void endOfRound() {
        newRound.setVisible(true);
    }

    /**
    * @return cont the parameter cont
    */
    public PokerGameController getCont() {
        return cont;
    }

    /**
    * @return raise the raise button
    */
    public Button getRaise() {
        return raise;
    }

    /**
    * @return call the call button
    */
    public Button getCall() {
        return call;
    }

    /**
    * @return fold the fold button
    */
    public Button getFold() {
        return fold;
    }

    /**
    * @return newRound the newRound button
    */
    public Button getNewRound() {
        return newRound;
    }

}