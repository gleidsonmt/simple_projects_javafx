package io.github.gleidsonmt.simple_projects.todo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  03/02/2024
 */
public class TaskCell extends GridPane {

    public TaskCell(String name, EventHandler<ActionEvent> event) {
        Label label = new Label(name);
        Button delete = new Button("X");
        this.getChildren().addAll(label, delete);
        delete.getStyleClass().add("delete");
        GridPane.setHgrow(label, Priority.ALWAYS);
        GridPane.setConstraints(label, 0,0);
        GridPane.setConstraints(delete, 1,0, 1,1, HPos.RIGHT, VPos.CENTER);
        
        delete.setOnAction(event);
    }
}
