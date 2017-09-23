package view;

import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import model.Card;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

/**
 * @author CS1331 TAs
 * @version 1.0
 */
public class CardView extends StackPane {

    private static final int CARD_HEIGHT = 110;
    private static final int CARD_WIDTH = 75;
    private static final String BACK_LOCATION = "File:./src/main/res/"
        + "playing-card-back.png";
    private static final String FRONT_LOCATION = "File:./src/main/res/"
        + "playing-card-front.png";
    private static Image backIm;
    private static Image frontIm;

    // statically loads Images
    static {
        backIm = new Image(BACK_LOCATION);
        frontIm = new Image(FRONT_LOCATION);
    }

    // the background image of the card
    private ImageView background;
    // the top left label where card value is displayed
    private Label topL;
    // the bottom left label where card value is displayed
    private Label botR;
    // the middle label where card suit is displayed
    private Label mid;
    // the card where card info is found
    private Card card;

    /**
     * Constructor for CardView
     */
    public CardView() {
        // if () {

        // }
        background = new ImageView(frontIm);
        background.setFitHeight(CARD_HEIGHT);
        background.setFitWidth(CARD_WIDTH);
        topL = new Label();
        mid = new Label();
        botR = new Label();
        getChildren().addAll(background, topL, mid, botR);
    }

    /**
     * Gives the CardView a Card object which contains information on the Card
     * @param c The Card to display
     */
    public void setCard(Card c) {
        card = c;
        topL.setText(c.getCardValue().getStr());
        // mid.setText(c.getSuit().getStr());
        // mid.setFont(new Font(40));
        // System.out.println(c.getCardValue().toString());
        if (c.getSuit().toString().equals("HEART")
            || c.getSuit().toString().equals("DIAMOND")) {
            mid.setText(c.getSuit().getStr());
            mid.setFont(new Font(40));
            mid.setTextFill(Color.web("#FF0000"));
            botR.setTextFill(Color.web("#FF0000"));
            topL.setTextFill(Color.web("#FF0000"));
        } else {
            mid.setText(c.getSuit().getStr());
            mid.setFont(new Font(40));
        }
        botR.setText(c.getCardValue().getStr());

        topL.setTranslateX(15 - CARD_WIDTH / 2);
        topL.setTranslateY(topL.getLayoutBounds().getHeight() / 2 + 5
            - CARD_HEIGHT / 2);
        botR.setTranslateX(CARD_WIDTH / 2 - 15);
        botR.setTranslateY(botR.getLayoutBounds().getHeight() / -2 - 5
            + CARD_HEIGHT / 2);
    }

    /**
     * Shows the front of the Card
     */
    public void show() {
        background.setImage(frontIm);
        topL.setVisible(true);
        mid.setVisible(true);
        botR.setVisible(true);
        background.setVisible(true);


    }

    /**
     * Makes the card not display at all
     */
    public void hide() {

        background.setVisible(false);
        topL.setVisible(false);
        mid.setVisible(false);
        botR.setVisible(false);
    }

    /**
     * Shows the back of the card.
     */
    public void hideDetails() {

        background.setImage(backIm);
        topL.setVisible(false);
        mid.setVisible(false);
        botR.setVisible(false);
        background.setVisible(true);
    }
}