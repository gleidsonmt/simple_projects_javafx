package io.github.gleidsonmt.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
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
        Title title = new Title("TicTacToe");
        PlayButton playButton = new PlayButton();
        Board board = new Board(playButton);
        VBox body = new VBox(title, board, playButton);
        body.setAlignment(Pos.CENTER);
        root.getChildren().add(body);
        root.setAlignment(Pos.CENTER);
        board.setAlignment(Pos.CENTER);
        VBox.setVgrow(board, Priority.ALWAYS);
        stage.setScene(new Scene(root, 800, 720));
        stage.setMinHeight(600);
        stage.setMinWidth(600);
        stage.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.show();

        playButton.setOnAction(event -> {
            playButton.setDisable(true);
            body.getChildren().remove(board);
            Board bd = new Board(playButton);
            body.getChildren().add(1, bd);
            bd.setAlignment(Pos.CENTER);
            VBox.setVgrow(bd, Priority.ALWAYS);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
