
package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Adam
 */
public class ScreensFramework extends Application {

    public static String screen1ID = "HomePage";
    public static String screen1File = "homepage.fxml";
    public static String screen2ID = "ThemePage";
    public static String screen2File = "Theme.fxml";
    public static String screen3ID = "cartPage";
    public static String screen3File = "cart.fxml";

    @Override
    public void start(Stage primaryStage) {
        
        //loads the pages and thier fxml file 
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        mainContainer.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
        
        //sets the screen to the main page as a defult 
               mainContainer.setScreen(ScreensFramework.screen1ID);
               
               // sets a default background for the main page 
               mainContainer.setStyle("-fx-background-image : url('/pic/background4.jpg')");
 
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    
    public static void main(String [] args){
        
        launch(args );
    }
    
}
