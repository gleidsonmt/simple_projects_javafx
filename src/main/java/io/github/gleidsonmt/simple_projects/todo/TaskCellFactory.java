package io.github.gleidsonmt.simple_projects.todo;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  03/02/2024
 */
public class TaskCellFactory implements Callback<ListView<Task>, ListCell<Task>> {
    @Override
    public ListCell<Task> call(ListView<Task> param) {
        return new ListCell<>() {
            @Override
            protected void updateItem(Task item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setGraphic(new TaskCell(item.name()));
                    setText(null);
                } else {
                    setText(null);
                    setGraphic(null);
                }
            }
        };
    }
}
