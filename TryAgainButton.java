/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Felkng
 */
public class TryAgainButton extends VBox{

    public TryAgainButton (EventHandler<ActionEvent> eh) {
        Label end = new Label("GAME OVER");
        end.setFont(Font.font("Space Bd BT",50));
        end.setTextFill(Color.RED);
        this.getChildren().add(end);
        Button bAgain = new Button("TRY AGAIN");
        bAgain.setFont(Font.font("Space Bd BT",25));
        bAgain.setOnAction(eh);
        this.getChildren().add(bAgain);
        this.setMinWidth(GameConfig.WIDTH);
        this.setMinHeight(GameConfig.HEIGHT);
        this.setAlignment(Pos.CENTER);
    }
    
}
