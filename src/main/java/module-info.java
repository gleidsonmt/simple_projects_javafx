module io.github.gleidsonmt.simple_projects {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.gleidsonmt.simple_projects to javafx.fxml;
    exports io.github.gleidsonmt.simple_projects;
}