
package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Adam
 */


public class ThemePage extends Application {
    
    Stage window ;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        window=primaryStage;
        window.setTitle("WeatherApp");
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(HomePage.class.getClassLoader().getResource("view/Theme.fxml"));
        AnchorPane themepage = (AnchorPane) loader.load();
        
        
        Scene scene=new Scene(themepage);
        scene.getStylesheets().add(getClass().getResource("view/theme.css").toExternalForm());
        window.setScene(scene);
        window.show();
   
    }
 
    public static void main(String [] args)
    {
        launch(args);
    }
    
    
}
