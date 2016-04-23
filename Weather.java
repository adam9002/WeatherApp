
package model;

import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;

public final class Weather{

    WeatherDoc doc= new WeatherDoc("44418","c");
    WeatherDisplay display=new WeatherDisplay();
    
    public static String [][] forecas= new String[5][2];
    
    
    public Weather(){
        
        
        getWeatherTempL();
        getWeatherCity();
        getWeatherCondtion();
        
    }
    
    public String getWeatherUni(){
        
        String tempUnit= display.getTemperatureUnit();
        
        return tempUnit;
    }
    
    public String getWeatherTempL()
    {
        String tempL=display.getTemperature();
        
        return tempL;
    }
    
    public String getWeatherCity()
    {
        String city= display.getCity();
        
        return city;
    }
    
    public String getWeatherCondtion()
    {
        String condition= display.getCondition();
        
        return condition;
    }
    
    public String getcurrentDay()
    {
        
        String currentday=WeatherFo.getCurrentDay();
        
        return currentday;
        
    }
    
    
    
    
}
