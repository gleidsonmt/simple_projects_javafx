package io.github.gleidsonmt.tictactoe;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/01/2024
 */
public class BoardEngine {

    private String act = "x";
    private final Player playerOne = new Player();
    private final Player playerTwo = new Player();

    private final BoardSignCreator design = new BoardSignCreator();


    public BoardEngine() {
        playerOne.setType("x");
        playerTwo.setType("o");
    }

    public void move(Label label) {
        if (Objects.equals(act, "x")) {
            label.setUserData("x");
            label.setText("x");
            design.drawX(label);
            act = "o";
        } else {
            label.setUserData("o");
            label.setText("O");
            design.drawO(label);
            act = "x";
        }
    }

    boolean win = false;

    public boolean hasWinner() {
        return win;
    }

    public void select(Label label) {

        if (label.getUserData() != null) return;
        this.move(label);

//        win = this.checkWin(this.getChildren()) != null;

//        playButton.setDisable(!win);
    }

    public Player checkWin(ObservableList<Node> labels) {
        Player winner = null;

        Label[][] board = new Label[3][3];

        int acc = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (Label) labels.get(j + (acc));
            }
            acc+=3;
        }

        acc = 0;
        String verify = null;
        for (int i = 0; i < 3; i++) {

            // horizontally
            if (equal(board[i][0], board[i][1]) && equal(board[i][1], board[i][2])) {
                for (int z = 0; z < 3; z++) {
                    board[i][z].getStyleClass().add("win-label");
                }
                verify = board[i][0].getText();
            }

            // vertically
            if (equal(board[0][i], board[1][i]) && equal(board[1][i], board[2][i])) {
                for (int z = 0; z < 3; z++) {
                    board[z][i].getStyleClass().add("win-label");
                }
                verify = board[0][i].getText();
            }

            // diagon 1
            if (equal(board[0][0], board[1][1]) && equal(board[1][1], board[2][2])) {
                for (int z = 0; z < 3; z++) {
                    board[z][z].getStyleClass().add("win-label");

                }
                verify = board[0][0].getText();
            }

            // diagon 2
            if (equal(board[0][2], board[1][1]) && equal(board[1][1], board[2][0])) {
                for (int z = 0; z < 3; z++) {
                    board[z][2-z].getStyleClass().add("win-label");
                }
                verify = board[i][2].getText();
            }

            if (Objects.equals(verify, "x")) {
                winner = playerOne;
            } else winner = playerTwo;

            acc+=3;
        }
        win = verify != null;
        return verify == null ? null : winner;
    }

    private boolean equal(Object xx, Object yy) {

        if (xx == null || yy == null) return false;

        String x = ((Label)xx).getText();
        String y = ((Label)yy).getText();

        return x.equals(y);
    }


}
