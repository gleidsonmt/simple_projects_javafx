module io.github.gleidsonmt.simple_projects {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.gleidsonmt.simple_projects to javafx.fxml;
    exports io.github.gleidsonmt.simple_projects;
    exports io.github.gleidsonmt.simple_projects.tictactoe;
    opens io.github.gleidsonmt.simple_projects.tictactoe to javafx.fxml;
}