package io.github.gleidsonmt.simple_projects.todo;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

    public ToDoPanel() {
        root.getStyleClass().add("wire");
        form.getStyleClass().add("wire-1");
        scroller.getStyleClass().add("wire-2");

        root.setPadding(new Insets(20, 50, 20, 50));
        root.setSpacing(20);
        root.getChildren().setAll(form, scroller);
    }

    private GridPane createForm() {
        GridPane form = new GridPane();
        form.add(new Label("Task Nmae"),0,0 );
        form.add(new TextField("Place"),1,0 );
        form.add(new Button("Add"),2,0 );
        return form;
    }

    public VBox getRoot() {
        return root;
    }



}
