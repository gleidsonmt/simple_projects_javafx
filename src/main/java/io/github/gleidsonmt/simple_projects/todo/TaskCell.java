package io.github.gleidsonmt.simple_projects.todo;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  03/02/2024
 */
public class TaskCell extends GridPane {

    public TaskCell(String name) {
        Label label = new Label(name);
        this.getChildren().add(label);

    }
}
