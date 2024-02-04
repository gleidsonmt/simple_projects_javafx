package io.github.gleidsonmt.simple_projects.todo;


import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  03/02/2024
 */
public class TaskList extends ListView<Task> {

    public TaskList() {
        setCellFactory(new TaskCellFactory());
    }
}
