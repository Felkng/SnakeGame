/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Felkng
 */
public class Score extends HBox{
    Integer Nscore;
    Label score;
    public Score(Integer scoreX) {
        this.Nscore = scoreX;
        score = new Label(this.Nscore.toString());
        score.setFont(Font.font("Space Bd BT",50));
        score.setTextFill(Color.CRIMSON);
        this.getChildren().add(score);
        this.setMinWidth(GameConfig.WIDTH);
        this.setMinHeight(GameConfig.HEIGHT);
        this.setAlignment(Pos.TOP_CENTER);
    }
    
    public void setScore(Integer x){
        this.Nscore = x;
    }
    
}
