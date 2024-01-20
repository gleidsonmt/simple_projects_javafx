module io.github.gleidsonmt.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.gleidsonmt.tictactoe to javafx.fxml;
    exports io.github.gleidsonmt.tictactoe;
}