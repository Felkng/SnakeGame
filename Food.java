/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author Felkng
 */
public class Food {
    private Canvas food;

    public Food() {
        createFood();
        setRandPos();
    }
    
    public void createFood(){
        Image img = new Image(getClass().getResourceAsStream("apple.png"));
        this.food = CanvasUtils.buildSquare(Color.BLANCHEDALMOND,img);
    }
    
    public Integer randNum(Integer min, Integer max){
        int val = (int) (Math.random() * ((max-min) + 1 )) + min;
        return val - (val % GameConfig.SQUARE_SIZE);
    }
    
    public void setRandPos(){
        this.food.setTranslateX(randNum(0, GameConfig.WIDTH - GameConfig.SQUARE_SIZE));
        this.food.setTranslateY(randNum(0, GameConfig.HEIGHT - GameConfig.SQUARE_SIZE));
    }

    public Canvas getFood() {
        return food;
    }
    
    public Integer getXpos(){
        return (int)this.food.getTranslateX();
    }
    
    public Integer getYpos(){
        return (int)this.food.getTranslateY();
    }
}
