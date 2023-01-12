/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author Felkng
 */
public class CanvasUtils {
    public static Canvas buildSquare(Color cor, Image img){
        Canvas square = new Canvas(GameConfig.SQUARE_SIZE,GameConfig.SQUARE_SIZE);
        GraphicsContext gc = square.getGraphicsContext2D();
        gc.setFill(cor);
        gc.fillRect(0, 0, GameConfig.SQUARE_SIZE, GameConfig.SQUARE_SIZE);
        //gc.strokeRect(0, 0, GameConfig.SQUARE_SIZE, GameConfig.SQUARE_SIZE);
        gc.drawImage(img, 0, 0, GameConfig.SQUARE_SIZE, GameConfig.SQUARE_SIZE);
        return square;
    }
    
    
}
