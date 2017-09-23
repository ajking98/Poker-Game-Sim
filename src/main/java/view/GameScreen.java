package view;

import javafx.scene.layout.BorderPane;
import viewcontroller.PokerGameController;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class GameScreen extends BorderPane {

    private PlayerArea topPlayer;
    private PlayerArea leftPlayer;
    private PlayerArea bottomPlayer;
    private PlayerArea rightPlayer;
    private BoardArea boardArea;

    /**
     * GameScreen's constructor
     * @param controller The PokerGameController to interact with
     */
    public GameScreen(PokerGameController controller) {
        leftPlayer = new VerticalPlayer(controller.getLeftPlayer());
        topPlayer = new HorizontalPlayer(controller.getTopPlayer());
        rightPlayer = new VerticalPlayer(controller.getRightPlayer());
        bottomPlayer = new HorizontalPlayer(controller.getBottomPlayer());
        boardArea = new BoardArea(controller.getBoard());
        this.setTop(topPlayer.playerPane());
        this.setLeft(leftPlayer.playerPane());
        this.setRight(rightPlayer.playerPane());
        this.setBottom(bottomPlayer.playerPane());
        this.setCenter(boardArea.getPane());
        this.updatesMade();


    }

    /**
     * This method is called whenever normal updates to the UI need to be made.
     */
    public void updatesMade() {
        topPlayer.update(false);
        bottomPlayer.update(true);
        leftPlayer.update(false);
        rightPlayer.update(false);
        boardArea.update();
    }

    /**
     * This method is called whenever a round of poker ends
     */
    public void endOfRound() {
        topPlayer.update(true);
        bottomPlayer.update(true);
        leftPlayer.update(true);
        rightPlayer.update(true);
        boardArea.update();
    }

}