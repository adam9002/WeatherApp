
package controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HomePage extends Application{
    
  Stage window ;
  
  
       
   @Override
    public void start(Stage primaryStage) throws IOException{
      
        
        window=primaryStage;
        window.setTitle("WeatherApp");

                 //load home page
                 
                 FXMLLoader loader = new FXMLLoader();
                  
                 loader.setLocation(HomePage.class.getClassLoader().getResource("view/homepage.fxml"));
                  AnchorPane homepage = (AnchorPane) loader.load();
                    
                
                  
                  Scene scene=new Scene(homepage);
                  scene.setFill(null);
                  
                  window.initStyle(StageStyle.TRANSPARENT);
                   
                    window.setScene(scene);
                    window.show();
                   
                    scene.getStylesheets().add(getClass().getResource("view/mainpage.css").toExternalForm());
                 
               
    }
         
         
       


    public static void main(String[] args) {
       
       Application.launch(args);
    }
    
    
    
    
}
