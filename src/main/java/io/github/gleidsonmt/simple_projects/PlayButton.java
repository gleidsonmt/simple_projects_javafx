package io.github.gleidsonmt.simple_projects;

import javafx.scene.control.Button;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/01/2024
 */
public class PlayButton extends Button {

    public PlayButton() {
        getStyleClass().add("btn-play");
        setPrefSize(150, 40);
        setText("Play Again");
        setDisable(true);
    }
}
