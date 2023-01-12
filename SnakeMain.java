
package snakegame;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Felkng
 */
public class SnakeMain extends Application{
    
    public static void main(String[] args) {
        Application.launch(args);
        
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Snake snake = new Snake();
        Food food = new Food();
        Scenario scenario = new Scenario(stage, snake, food);
        GameEvents gaming = new GameEvents(scenario, snake, food);
    }
    
}
