module io.github.gleidsonmt.simple_projects {
    requires javafx.controls;
    requires javafx.fxml;

    requires fr.brouillard.oss.cssfx;


    opens io.github.gleidsonmt.simple_projects to javafx.fxml;
    exports io.github.gleidsonmt.simple_projects;
    exports io.github.gleidsonmt.simple_projects.tictactoe;
    opens io.github.gleidsonmt.simple_projects.tictactoe to javafx.fxml;
}