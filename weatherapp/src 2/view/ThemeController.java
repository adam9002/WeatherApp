/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.HomePage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;


/**
 * FXML Controller class
 *
 * @author Adam
 */

public class ThemeController implements Initializable,ControlledScreen {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @FXML 
    private Button img1;
    
    @FXML
    private Button img2;
    
    @FXML
    private Button img3;
    
   Image imageV1;
   
   HomePage backg = new HomePage();
   
ScreensController myController; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
      
    }   
    
    
    @Override
    public void setScreenParent(ScreensController screenParent){
         myController=screenParent;
         
    }
   
    @FXML
    public void goToScreen1(ActionEvent event)
    {
        myController.setScreen(ScreensFramework.screen1ID);
         myController.setStyle("-fx-background-image : url('/pic/background4.jpg')");
    }
    
    
    @FXML
    public void setfirsttheme(ActionEvent e)
    {
        myController.setScreen(ScreensFramework.screen1ID);
        myController.setStyle("-fx-background-image : url('/pic/background1.jpg')");
    }
    
    @FXML
    public void setsecondtheme(ActionEvent e)
    {
        myController.setScreen(ScreensFramework.screen1ID);
        myController.setStyle("-fx-background-image : url('/pic/background2.jpg')");
    }
    
    @FXML
    public void setThirdtheme(ActionEvent e)
    {
        myController.setScreen(ScreensFramework.screen1ID);
        myController.setStyle("-fx-background-image : url('/pic/background3.jpg')");
    }
   
}
