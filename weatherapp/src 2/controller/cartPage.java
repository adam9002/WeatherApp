
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
public class cartPage extends Application {
    
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        window=primaryStage;
        window.setTitle("WeatherApp");
 
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(cartPage.class.getClassLoader().getResource("view/cart.fxml"));
        AnchorPane cartpage = (AnchorPane) loader.load();
        
        Scene scene=new Scene(cartpage);
        
        window.setScene(scene);
        window.show();
        
        scene.getStylesheets().add(getClass().getResource("view/mainpage.css").toExternalForm());
  
    }

    public static void main(String[] args) {
        
        launch(args);
    }
    
    
}


