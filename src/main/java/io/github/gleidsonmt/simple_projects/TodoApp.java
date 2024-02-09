package io.github.gleidsonmt.simple_projects;

import fr.brouillard.oss.cssfx.CSSFX;
import io.github.gleidsonmt.simple_projects.todo.ToDoPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  03/02/2024
 */
public class TodoApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new ToDoPanel().getRoot(), 800, 600));
        stage.show();

        stage.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("wireframe.css")).toExternalForm());
        stage.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("todo/style.css")).toExternalForm());

        CSSFX.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
