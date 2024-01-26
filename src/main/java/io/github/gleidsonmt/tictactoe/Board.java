package io.github.gleidsonmt.tictactoe;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/01/2024
 */
public class Board {

    private final BoardEngine engine = new BoardEngine();
    private final PlayButton playButton;

    private final GridPane grid = new GridPane();

    public Board(PlayButton playButton) {

        this.playButton = playButton;

        refresh();

        Platform.runLater(() ->
                grid.getScene().setOnKeyReleased(event -> {
//            board
                    if (event.getText().matches("[^0-9]")) return; // no letters
                    if (Integer.parseInt(event.getText()) < 1) return; // no zero index

                    update((Label) grid.getChildren().get(Integer.parseInt(event.getText()) - 1));

                }));


    }

    public Node getRoot() {
        return grid;
    }

    public void refresh() {
        grid.getChildren().clear();
        int acc = 0;

        grid.setAlignment(Pos.CENTER);
        int rows = 3, cols = 3;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                Label label = createBlankLabel(String.valueOf(++acc));
                grid.add(label, j, i);
                label.setOnMouseClicked(event -> update(label));

            }
        }
        createBorders();
    }

    private void update(Label label) {
        if (engine.hasWinner()) return;
        engine.select(label);
        playButton.setDisable(engine.checkWin(grid.getChildren()) == null);
    }

    private void createBorders() {
        grid.getChildren().get(0).setStyle("-fx-border-color: rgba(0,0,0,0.6); -fx-border-width: 0px 2px 2px 0px");
        grid.getChildren().get(2).setStyle("-fx-border-color: rgba(0,0,0,0.6); -fx-border-width: 0px 0px 2px 2px");

        grid.getChildren().get(6).setStyle("-fx-border-color: rgba(0,0,0,0.6); -fx-border-width: 2px 2px 0px 0px");
        grid.getChildren().get(8).setStyle("-fx-border-color: rgba(0,0,0,0.6); -fx-border-width: 2px 0px 0px 2px");

        grid.getChildren().get(7).setStyle("-fx-border-color: rgba(0,0,0,0.6); -fx-border-width: 2px 0px 0px 0px");
        grid.getChildren().get(1).setStyle("-fx-border-color: rgba(0,0,0,0.6); -fx-border-width: 0px 0px 2px 0px");

        grid.getChildren().get(5).setStyle("-fx-border-color: rgba(0,0,0,0.6); -fx-border-width: 0px 0px 0px 2px");
        grid.getChildren().get(3).setStyle("-fx-border-color: rgba(0,0,0,0.6); -fx-border-width: 0px 2px 0px 0px");
    }

    private Label createBlankLabel(String text) {
        Label blankLabel = new Label(text);
        blankLabel.setAlignment(Pos.CENTER);
        blankLabel.setPrefSize(120, 120);
        return blankLabel;
    }
}
