/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.Weather;
import model.WeatherFo;
/**
 *
 * @author Adam
 */
public class homepageController implements Initializable,ControlledScreen{
  
    
    Weather london = new Weather();
    WeatherFo forecast= new WeatherFo("London");
    ScreensController myController;
    
     
     @FXML
    private Label temp;
      
      @FXML 
      private Label  city;
      @FXML 
      private Label condition;
      
      @FXML
      private Label currentday;
      
      @FXML
      private ImageView conditionIm;
      
      
      @FXML
      private Label day1;
      
      @FXML
     private  Label day2;
      
       @FXML
     private  Label day3;
        
       @FXML
      private Label day4;
       
        @FXML
      private Label day5;
      
        
         @FXML
      private ImageView imgD1;
         
         @FXML
      private ImageView imgD2;
         
         @FXML
      private ImageView imgD3;
         
         @FXML
      private ImageView imgD4;
         
         @FXML
      private ImageView imgD5;
         
      
              
      
    Image cloudy=new Image("pic/partly.png");
    Image sunny=new Image("pic/sunny.png");
    Image partlyC=new Image("pic/partly.png");
    Image rainy=new Image("pic/rain.png");
    Image snow=new Image("pic/snow.png");
    Image foggy =new Image("pic/foggy.png");
    
   
    public homepageController() {
        
     }
    
    
    //private void initialize()
   @Override
    public void initialize(URL location, ResourceBundle resources){
         
        FiveDayForecast();
        temp.setText(london.getWeatherTempL());
       //unit.setText(london. getWeatherUni());
       city.setText(london.getWeatherCity());
        condition.setText(london.getWeatherCondtion());
         currentday.setText (london.getcurrentDay()); 
   
        
         FadeTransition fadeTransition = 
            new FadeTransition(Duration.millis(3000),conditionIm);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        
        FadeTransition fadeTransition1 = 
            new FadeTransition(Duration.millis(3000),temp);
        fadeTransition1.setFromValue(1.0f);
        fadeTransition1.setToValue(0.3f);
        fadeTransition1.setCycleCount(2);
        fadeTransition1.setAutoReverse(true);
        
        
       
        
         ScaleTransition scaleTransition = 
            new ScaleTransition(Duration.millis(2000), conditionIm);
        scaleTransition.setToX(2f); 
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);
        
        
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll( 
               
                fadeTransition,
                 fadeTransition1,
                scaleTransition
        
        );
              
             
       parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();
             
        if(london.getWeatherCondtion().contains("Fog")) {
        
            conditionIm.setImage(foggy);
        }      
        else if(london.getWeatherCondtion().contains("Partly Cloudy")){
            conditionIm.setImage(partlyC);
              
        } 
        
        
    }
    
     @Override
    public void setScreenParent(ScreensController screenParent)
    {
        myController=screenParent;
        
    }
    
    @FXML
    public void FiveDayForecast()
    {
        day1.setText(WeatherFo.dayInfo[0][0]);
        imgD1.setImage(partlyC);

        day2.setText(WeatherFo.dayInfo[1][0]);
           imgD2.setImage(foggy); 
        
        day3.setText(WeatherFo.dayInfo[2][0]);
         imgD3.setImage(sunny);
        
         day4.setText(WeatherFo.dayInfo[3][0]);
        imgD4.setImage(sunny);
       
        day5.setText(WeatherFo.dayInfo[4][0]);
         imgD5.setImage(cloudy);
    }
            
    
    @FXML
    private void goTOScreen2(ActionEvent event1){
        
        myController.setScreen(ScreensFramework.screen2ID);
        
    }
    
    @FXML
    private void goTOscreen3(ActionEvent event2)
    {
         myController.setScreen(ScreensFramework.screen3ID);
    }
    
    
}
