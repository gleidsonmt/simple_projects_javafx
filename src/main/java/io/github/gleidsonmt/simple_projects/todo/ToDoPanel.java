package io.github.gleidsonmt.simple_projects.todo;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  03/02/2024
 */
public class ToDoPanel {

    private final VBox root = new VBox();
    private final GridPane form = createForm();
    private final ScrollPane scroller  = new ScrollPane();
    private final VBox body  = new VBox();
    private final TaskList taskList  = new TaskList();

    public ToDoPanel() {
        root.getStyleClass().add("wire");
        form.getStyleClass().add("wire");
        scroller.getStyleClass().add("wire");

        root.setPadding(new Insets(50, 150, 50, 150));
        root.setSpacing(20);
        root.getChildren().setAll(form, scroller);
        scroller.setContent(body);
        body.getChildren().add(taskList);
        scroller.setFitToWidth(true);
        scroller.setFitToHeight(true);
        VBox.setVgrow(scroller, Priority.ALWAYS);
        VBox.setVgrow(taskList, Priority.ALWAYS);

    }

    private GridPane createForm() {
        GridPane form = new GridPane();
        form.setHgap(20);

        Label label = new Label("Task Name:");
        TextField textField = new TextField();
        label.setLabelFor(textField);
        Button button = new Button("Add");

        form.getChildren().setAll(label, textField, button);

        HPos[] hPos = {HPos.LEFT, HPos.CENTER, HPos.RIGHT};

        for (int i = 0; i < 3; i++) {
            aignVertically(form.getChildren().get(i), i, hPos[i]);
        }

        GridPane.setHgrow(textField, Priority.ALWAYS);

        button.setOnAction(event -> {
            taskList.getItems().add(new Task(textField.getText()));
        });

        return form;
    }

    private void aignVertically(Node node, int col, HPos position) {
        GridPane.setConstraints(node, col, 0, 1,1, position, VPos.CENTER);
    }

    public VBox getRoot() {
        return root;
    }



}
