package deal_or_no_deal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author ELDHOSE SHAJI
 * The Main Java Class
 */
public class DEAL_OR_NO_DEAL extends Application {
    
    //Diffrerent Stages 
    static Stage login = new Stage();
    static Stage Game = new Stage();
    static Stage deal = new Stage();
    static Stage score = new Stage();
    
    //Respective Controllers for each stage
    static LoginWindowController loginController;
    static GameController gameController;
    static DealWindowController dealController;
    static ScoreController scoreController;
    
    /**
     * The Program start method
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        //Respective Fxmls are created for each stage
        FXMLLoader loginWindow = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
        FXMLLoader gameWindow = new FXMLLoader(getClass().getResource("Game.fxml"));
        FXMLLoader dealWindow = new FXMLLoader(getClass().getResource("DealWindow.fxml"));
        FXMLLoader scoreWindow = new FXMLLoader(getClass().getResource("Score.fxml"));
        
        //Assigning parents
        Parent loginRoot = loginWindow.load();
        Parent gameRoot = gameWindow.load();
        Parent dealRoot = dealWindow.load();
        Parent scoreRoot = scoreWindow.load();
        
        //Assigning respective controllers to their windows 
        loginController = loginWindow.getController();
        gameController = gameWindow.getController();
        dealController = dealWindow.getController();
        scoreController = scoreWindow.getController();
        
        //Setting up stages
        Scene loginScene = new Scene(loginRoot);
        Scene gameScene = new Scene(gameRoot);
        Scene dealScene = new Scene(dealRoot);
        Scene scoreScene = new Scene(scoreRoot);
        
        //Setting scenes for the stages
        login.setScene(loginScene);
        Game.setScene(gameScene);
        deal.setScene(dealScene);
        score.setScene(scoreScene);
        
        //calling login page to start the program
        showLogin();
        
    }
    
    /**
    *The function to show the login window
    */
    public static void showLogin(){
        login.show();
        loginController.onLoad();
        Game.hide();
    }
    
    /**
    *The main game play window
    */
    public static void showGame(){
        login.hide();
        gameController.onLoad();
        Game.show();
    }
    
    /**
    *The deal making window function
    */
    public static void showDeal(){
        deal.show();
        dealController.onLoad();
    }
    
    /**
     * The Score card function
     */
    public static void showScore(){
        Game.hide();
        score.show();
        scoreController.onLoad();
    }
    

    /**
     * The main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
