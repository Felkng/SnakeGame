/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Felkng
 */
public class Scenario {
    Stage stage;
    Snake snake;
    Group root = new Group();
    Scene scene;
    Score score;
    private Food food;
    public Scenario(Stage primaryStage, Snake snake, Food food) {
        stage = primaryStage;
        scene = new Scene(root);
        primaryStage.setTitle("Snake game-Felkng");
        primaryStage.setResizable(false);
        primaryStage.setMinWidth(GameConfig.WIDTH+16);
        primaryStage.setMinHeight(GameConfig.HEIGHT+96);
        primaryStage.setScene(scene);
        scene.setFill(Color.BLANCHEDALMOND);
        this.snake = snake;
        this.food = food;
        newScore(0);
        root.getChildren().add(snake.getHead());
        root.getChildren().add(food.getFood());
        primaryStage.show();
    }
    
    public void keyPressed(EventHandler<? super KeyEvent> eh){
        this.scene.setOnKeyPressed(eh);
    }
    public void showGameOver(GameEvents gameEvent){
        TryAgainButton tryAgain = new TryAgainButton(eh->{
            cleanScreen();
            root.getChildren().add(this.food.getFood());
            root.getChildren().add(snake.restart());
            gameEvent.GameLoop();
            cleanScore();
            newScore(0);
        });
        root.getChildren().add(tryAgain);
    }
    
    public void cleanScreen(){
        root.getChildren().remove(0,root.getChildren().size());
    }
    
    public void add(Node node){
        this.root.getChildren().add(node);
    }
    
    public void cleanScore(){
        root.getChildren().remove(score);
    }
    
    public void newScore(Integer x){
        this.score = new Score(x);
        add(score);
    }
    
    
    
    
}
