package io.github.gleidsonmt.simple_projects;

import io.github.gleidsonmt.simple_projects.tictactoe.Board;
import io.github.gleidsonmt.simple_projects.tictactoe.PlayButton;
import io.github.gleidsonmt.simple_projects.tictactoe.Title;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/01/2024
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        StackPane root = new StackPane();
        root.setPadding(new Insets(10));

        Label scoreOne = new Label();
        Label scoreTwo = new Label();

        Title title = new Title("TicTacToe");
        PlayButton playButton = new PlayButton();

        Board board = new Board(playButton);


        String model = "Player %s has %d victory points";

        scoreOne.textProperty().bind(
                Bindings.format(model,
                        board.playerName(0),
                        board.playerScore(0)
                )
        );

        scoreTwo.textProperty().bind(
                Bindings.format(model,
                        board.playerName(1),
                        board.playerScore(1)
                )
        );



        VBox body = new VBox(title, board.getRoot(), scoreOne, scoreTwo, playButton);
        body.setSpacing(10);
        VBox.setMargin(title, new Insets(10));
        VBox.setMargin(scoreOne, new Insets(10));
        VBox.setMargin(playButton, new Insets(10));
        body.setAlignment(Pos.CENTER);
        root.getChildren().add(body);
        root.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(root, 800, 720));
        stage.setMinHeight(600);
        stage.setMinWidth(600);
        stage.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.show();


        playButton.setOnAction(event -> {
            playButton.setDisable(true);
            board.refresh();
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
