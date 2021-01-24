package ca.cmpt213.asn4.tictactoe.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//contains UI for the game, and runs it
public class TicTacToe extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        //initialize basic elements
        UILogic uiLogic = new UILogic();
        Button newGame = new Button("New Game");
        newGame.setPrefSize(150,50);
        newGame.setFont(Font.font(15));
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                uiLogic.newGame();
            }
        });

        //initialize grouping
        VBox gameLayout = new VBox(10);
        gameLayout.getChildren().addAll(uiLogic.getGridPane(), uiLogic.getLabel(), newGame);
        gameLayout.setAlignment(Pos.CENTER);

        //initialize scene
        Scene playGame = new Scene(gameLayout, 650, 800);

        //set stage
        primaryStage.setScene(playGame);
        primaryStage.show();
        primaryStage.setTitle("Tic Tac Toe");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
