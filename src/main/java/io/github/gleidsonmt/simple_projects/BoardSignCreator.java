package io.github.gleidsonmt.simple_projects;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  19/01/2024
 */
public class BoardSignCreator {

    public void drawX(Label label) {
        Text text = new Text("X");
        text.setFont(new Font(80));
        text.setFill(Color.gray(0.60));
        label.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        label.setGraphic(text);
    }

    public void drawO(Label label) {
        Circle circle = new Circle(30);
        circle.setStrokeWidth(4);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.gray(0.60));
        label.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        label.setGraphic(circle);
    }
}
