/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author Felkng
 */
public class Snake{
    private Canvas Head;
    private List<Canvas> body = new ArrayList<>();
    private List<Integer[]> posHistory= new ArrayList<>();
       
    
    public Snake() {
        buildSnake();
    }
    
    private void buildSnake(){
        Image img = new Image(getClass().getResourceAsStream("Head.png"));
        this.Head = CanvasUtils.buildSquare(Color.BLANCHEDALMOND,img);
        setRandPos();
    }
    
    public Canvas getHead(){
        return Head;
    }
    
    public int getX(){
        return (int)Head.getTranslateX();
    }
    
    public int getY(){
        return (int)Head.getTranslateY();
    }
    
    public void setPosition(Integer X, Integer Y){
        this.Head.setTranslateX(X);
        this.Head.setTranslateY(Y);
        
        for (int i = 0; i < body.size(); i++) {
            Canvas bodyPart = body.get(i);
            Integer[] position = this.posHistory.get(this.posHistory.size() - (i + 1));
            bodyPart.setTranslateX(position[0]);
            bodyPart.setTranslateY(position[1]);
        }
        
        this.posHistory.add(new Integer[]{X,Y});
        
        if(posHistory.size() > body.size() + 1){
            posHistory.remove(0);
        }
    }
    
    public Integer randNum(Integer min, Integer max){
        int val = (int) (Math.random() * ((max-min) + 1 )) + min;
        return val - (val % GameConfig.SQUARE_SIZE);
    }
    
    public void setRandPos(){
        this.Head.setTranslateX(randNum(0, GameConfig.WIDTH - GameConfig.SQUARE_SIZE));
        this.Head.setTranslateY(randNum(0, GameConfig.HEIGHT - GameConfig.SQUARE_SIZE));
    }
    
    
    public void resetPos(){
        this.Head.setTranslateX((GameConfig.WIDTH/2)-GameConfig.SQUARE_SIZE);
        this.Head.setTranslateY((GameConfig.HEIGHT/2)-GameConfig.SQUARE_SIZE);
        
    }
    
    public Canvas restart(){
        setRandPos();
        this.posHistory.clear();
        this.body.clear();
        return Head;
    }
    
    public void eat(Scenario scenario){
        Image img = new Image(getClass().getResourceAsStream("Body.png"));
        Canvas bodyPart = CanvasUtils.buildSquare(Color.BLANCHEDALMOND,img);
        scenario.add(bodyPart);
        this.body.add(bodyPart);
    }
    
    public boolean checkColision(Integer X, Integer Y){
        for(Canvas bodyPart:this.body){
            Integer bodyPositionX = (int)bodyPart.getTranslateX();
            Integer bodyPosintionY = (int) bodyPart.getTranslateY();
            if(X.equals(bodyPositionX) && Y.equals(bodyPosintionY))
                return true;
        }
        return false;
    }
    
    public int getSize(){
        return body.size();
    }
    
    public void rotateSnakeHead(Integer value){
        Head.setRotate(value);
    }
    
    
}
