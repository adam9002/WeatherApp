/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.Weather;

 

/**
 * FXML Controller class
 *
 * @author Adam
 */
public class CartController implements Initializable,ControlledScreen {

    ScreensController  myController;
     Weather london = new Weather();
     
     
   
     Image poor =new Image("pic/poor.png");
      
     
    @FXML
    private Button store1;
       
    @FXML
      private ImageView comfort;
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(london.getWeatherCondtion().contains("Fog")) {
        
            comfort.setImage(poor);
            
            
        } else if(london.getWeatherCondtion().contains("Rain ")){
            comfort.setImage(poor);
              
        } 
        
        
        FadeTransition fadeTransition1 = 
            new FadeTransition(Duration.millis(3000), comfort);
        fadeTransition1.setFromValue(1.0f);
        fadeTransition1.setToValue(0.3f);
        fadeTransition1.setCycleCount(2);
        fadeTransition1.setAutoReverse(true);
        
          ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll( 
               
                fadeTransition1
                 
        
        );
              
             
       parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();
       
    }    

    @Override
    public void setScreenParent(ScreensController screenParent) {
        
         myController=screenParent;
    }
    
    
    public void goToscreen1(ActionEvent event )
    {
        myController.setScreen(ScreensFramework.screen1ID);
    }
   

    
    
}
