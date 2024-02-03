package io.github.gleidsonmt.simple_projects;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/01/2024
 */
public class Title extends HBox {

    public Title(String _text) {
        Text text = new Text(_text);
        text.setFont(new Font(40));
        this.getChildren().add(text);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
    }

}
