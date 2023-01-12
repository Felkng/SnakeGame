/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;


/**
 *
 * @author Felkng
 */
public class GameEvents {
    KeyCode currentDirection;
    Snake snake;
    Timeline timeline;
    Scenario scenario;
    private Food food;

    public GameEvents(Scenario scenario, Snake snake, Food food) {
        this.scenario = scenario;
        this.snake = snake;
        this.food = food;
        
        this.scenario.keyPressed(e->{
            KeyCode code = e.getCode();
            if(code.equals(KeyCode.LEFT) && currentDirection != KeyCode.RIGHT){
                currentDirection = code;
            }
            if(code.equals(KeyCode.RIGHT) && currentDirection != KeyCode.LEFT){
                currentDirection = code;
            }
            if(code.equals(KeyCode.UP) && currentDirection != KeyCode.DOWN){
                currentDirection = code;
            }
            if(code.equals(KeyCode.DOWN) && currentDirection != KeyCode.UP){
                currentDirection = code;
            }
        });
        GameLoop();
    }
    
    public void GameLoop(){
        timeline = new Timeline();
        KeyFrame keyframe = new KeyFrame(Duration.millis(90),t -> {
            Integer posX = snake.getX();
            Integer posY = snake.getY();
            Integer ct = snake.getSize()+1;
            if(KeyCode.RIGHT.equals(currentDirection)){
                posX = posX + GameConfig.SQUARE_SIZE;
                this.snake.rotateSnakeHead(0);
            }
            if(KeyCode.LEFT.equals(currentDirection)){
                posX = posX - GameConfig.SQUARE_SIZE;
                this.snake.rotateSnakeHead(180);
            }
            if(KeyCode.UP.equals(currentDirection)){
                posY = posY - GameConfig.SQUARE_SIZE;
                this.snake.rotateSnakeHead(270);
            }
            if(KeyCode.DOWN.equals(currentDirection)){
                posY = posY + GameConfig.SQUARE_SIZE;
                this.snake.rotateSnakeHead(90);
            }
            
            if(     posX < 0 || 
                    posY < 0 || 
                    posX > GameConfig.WIDTH-GameConfig.SQUARE_SIZE || 
                    posY > GameConfig.HEIGHT+GameConfig.SQUARE_SIZE || this.snake.checkColision(posX, posY)){
                GameOver();
            }else{ 
                if(posX.equals(food.getXpos()) && posY.equals(food.getYpos())){
                    food.setRandPos();
                    snake.eat(this.scenario);
                    scenario.cleanScore();
                    scenario.newScore(ct);
                    
                }
                snake.setPosition(posX, posY);
            }
            
            
        });
        timeline.getKeyFrames().add(keyframe);
        timeline.setCycleCount(Integer.MAX_VALUE);
        timeline.play();
    }
    
    public void GameOver(){
        timeline.stop();
        this.currentDirection=null;
        scenario.showGameOver(this);
    }
    
    public void IncrementScore(){
        
    }
    
    
    
   
}
