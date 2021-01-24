package ca.cmpt213.asn4.tictactoe.ui;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import static ca.cmpt213.asn4.tictactoe.game.GameLogic.checkEnd;
import static ca.cmpt213.asn4.tictactoe.game.GameLogic.checkWin;

//contains Logic for TicTacToe
public class UILogic {

    private boolean gameFinished;
    private int turn;
    private final int[][] values;
    private final ImageView[][] imageViews;
    private final GridPane gridPane;
    private Label label;
    private final Image xImage = new Image("file:img/xImage.png");
    private final Image oImage = new Image("file:img/oImage.png");

    public UILogic(){
        gameFinished = false;
        label = new Label("X Starts");
        label.setFont(Font.font(30));
        values = new int[4][4];
        imageViews = new ImageView[4][4];
        gridPane = new GridPane();
        Image blankImage = new Image("file:img/square.png");
        for(int a=0; a<4; a++){
            for(int b=0; b<4; b++){
                values[a][b] = 0;
                imageViews[a][b] = new ImageView(blankImage);
                imageViews[a][b].setPreserveRatio(true);
                imageViews[a][b].setFitHeight(150);
                gridPane.add(imageViews[a][b],b,a);
                imageViews[a][b].addEventHandler(MouseEvent.MOUSE_CLICKED, new ImageClickHandler());
            }
        }
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10,10,10,10));
    }

    public void newGame(){
        gameFinished = false;
        label.setText("X Starts");
        turn = 0;
        for(int a=0; a<4; a++){
            for(int b=0; b<4; b++){
                values[a][b] = 0;
                imageViews[a][b].setImage(new Image("file:img/square.png"));
            }
        }
    }

    class ImageClickHandler implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {
            if(!gameFinished){
                for (int c = 0; c < 4; c++) {
                    for (int d = 0; d < 4; d++) {
                        if ((ImageView) mouseEvent.getSource() == imageViews[c][d]) {
                            if (values[c][d] == 0) {
                                if (turn % 2 == 0) {
                                    ((ImageView) mouseEvent.getSource()).setImage(xImage);
                                } else {
                                    ((ImageView) mouseEvent.getSource()).setImage(oImage);
                                }
                                if (turn % 2 == 0) {
                                    label.setText("O's Turn");
                                    values[c][d] = 1; //X
                                } else {
                                    label.setText("X's Turn");
                                    values[c][d] = 2; //O
                                }
                                turn++;
                                break;
                            }
                        }
                    }
                }
            }
            if(checkWin(values) != 0){
                winScreen(checkWin(values));
            }
            else if(checkEnd(values)){
                winScreen(3);
            }
        }
    }

    public void winScreen(int result){
        if(result == 1){
            label.setText("X Won");
        }
        else if(result == 2){
            label.setText("O Won");
        }
        else{
            label.setText("Tied Game");
        }
        gameFinished = true;
    }

    public GridPane getGridPane(){
        return gridPane;
    }

    public Label getLabel(){
        return label;
    }
}
