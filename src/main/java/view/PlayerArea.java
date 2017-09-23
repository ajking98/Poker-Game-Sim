package view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import model.Player;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public abstract class PlayerArea {

    private Pane pane;
    private CardView card1;
    private CardView card2;
    private Label outOfPlay;
    private Label chips;
    private Label name;
    private Player player;

    /**
     * PlayerArea's constructor
     * @param  pane   The Pane where all UI elements will be added. The type of
     * pane is decided by subclasses
     * @param  player The Player who's information will be tracked
     */
    public PlayerArea(Pane pane, Player player) {
        this.pane = pane;
        this.player = player;

        card1 = new CardView();
        card2 = new CardView();
        name = new Label(player.toString());
        chips = new Label(Integer.toString(player.getMoney()));
        outOfPlay = new Label("Out of play");

        VBox vBox = new VBox();
        vBox.getChildren().add(name);
        vBox.getChildren().add(chips);
        vBox.getChildren().add(outOfPlay);
        pane.getChildren().addAll(card1, card2, vBox);
    }

    /**
     * Getter for the Pane that contains all of the UI elements.
     * @return The Pane that contains all of the UI elements.
     */
    public Pane playerPane() {
        return pane;
    }

    /**
     * This method is called whenever an update to the UI needs to be made.
     * @param showDetails is true whenever the details of the front of the
     * cards are supposed to be shown false otherwise
     */
    public void update(boolean showDetails) {
        chips.setText("Chips: " + player.getMoney());
        if (player.getCard(0) != null) {
            card1.setCard(player.getCard(0));
        }
        if (player.getCard(1) != null) {
            card2.setCard(player.getCard(1));
        }
        if (!showDetails && !player.getOutOfPlay()) {
            card1.hideDetails();
            card2.hideDetails();
            outOfPlay.setVisible(false);
        } else if (player.getOutOfPlay()) {
            card1.hide();
            card2.hide();
            outOfPlay.setVisible(true);
        } else {
            card1.show();
            card2.show();
            outOfPlay.setVisible(false);
        }
        // } else {
        //     if (showDetails) {
        //         card1.show();
        //         card2.show();
        //     } else {
        //         card1.hide();
        //         card2.hide();
        //     }
    }
        // if (!showDetails && !player.getOutOfPlay()) {
        //     card1.hideDetails();
        //     card2.hideDetails();
        // } else if (player.getOutOfPlay()) {
        //     card1.hide();
        //     card2.hide();
        //     outOfPlay.setVisible(true);
        // }
            // card1.setCard(player.getCard(0));
            // card2.setCard(player.getCard(1));

}
