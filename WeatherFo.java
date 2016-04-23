package model;

import java.net.*;
import java.util.regex.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeatherFo//try to sort out places with two parts e.g. potters bar
{
    static String fullWeatherText;
    static String[] day = new String[5];
    static String store;
    static String location;
    
    //[0][-]=day 0 (today), [0][-]=day 1 (tomorrow), ect...
    //[-][0]=day, [-][1]=date, [-][2]=low, [-][3]=high, [-][4]=condition
    public static String[][] dayInfo = new String[5][2];
    
    public WeatherFo(String location)
    {
        getWeatherInfo(location);
        getDailyInfo();
    }
    
    public static String getWOEID(String loc)//called by the getWeatherInfo method
    {
        String location = "";
        int countToAddSpace = 0;
        
        try//if the location name is made of two parts, e.g. new york.
        {
            String[] locationStringArray = loc.split("\\s+");
            
            for(int i=0; i<locationStringArray.length; i++)
            {
                if(countToAddSpace >= 1)
                {
                    location = location + " ";
                    //System.out.println(location);
                    //countToAddSpace++;
                }
                
                location = location + locationStringArray[i].substring(0,1).toUpperCase()+locationStringArray[i].substring(1);
                //System.out.println(location);
                countToAddSpace++;                
            }
            
            location = location.replaceAll("\\s", "-");
        }
        catch(PatternSyntaxException ex)
        {
            System.err.println();
        }
      
        int textInt = 0;
        
	try
	{
            URL url = new URL("http://where.yahooapis.com/v1/places.q('" + location + "')?appid=[1f170dd1953523e4f564adebeb33de8b0e255c90--]");
            URLConnection con = url.openConnection();
            Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
            Matcher m = p.matcher(con.getContentType());
            /* If Content-Type doesn't match this pre-conception, choose default and 
             * hope for the best. */
            String charset = m.matches() ? m.group(1) : "ISO-8859-1";
            Reader r = new InputStreamReader(con.getInputStream(), charset);
            StringBuilder buf = new StringBuilder();
            while (true)
            {
            	int ch = r.read();
            	if (ch < 0)
		{
                    break;
		}
		buf.append((char) ch);
            }
            String text = buf.toString();
            
            location = location.replaceAll("[-]", " ");//removes the - between trhe name of the location
            

            Pattern pattern = Pattern.compile("woeid=\"\\w+\\\">" + location);
            Matcher matcher = pattern.matcher(text);
            if(matcher.find())
            {
               
		String hold = matcher.group(0);
		textInt = Integer.parseInt(hold.replaceAll("[\\D]", ""));
		
            }
            else
            {
		System.out.println("Match not found");
            }
	}
	catch(Exception e)
        {
            System.err.println("Weather API Exception: "+e);
	}
        
        String woeidString = Integer.toString(textInt);
        return woeidString;
    }
    
    public static void getWeatherInfo(String location)
    {
        String WOEID = getWOEID(location);
        
        WeatherAPI weather = new WeatherAPI(WOEID);
       
        
        fullWeatherText = WeatherAPI.theWeatherRSS;
        
        
        
    }
    
    public static String getCurrentDay()
    {
        Calendar calendar = Calendar.getInstance();
        int dayInt = calendar.get(Calendar.DAY_OF_WEEK); 
        
        String day;
        
        if(dayInt == 1)
        {
            day = "Sunday";
        }
        else if(dayInt == 2)
        {
            day = "Monday";
        }
        else if(dayInt == 3)
        {
            day = "Tuesday";
        }
        else if(dayInt == 4)
        {
            day = "Wednesday";
        }
        else if(dayInt == 5)
        {
            day = "Thursday";
        }
        else if(dayInt == 6)
        {
            day = "Friday";
        }
        else
        {
            day = "Saturday";
        }

        return day;
    }
    
   
    

    public static void getDailyInfo()
    {
        int counter = 0;
        
        Pattern pattern = Pattern.compile("<yweather:forecast .*? />");
        Matcher matcher = pattern.matcher(fullWeatherText);
        
        
                
        while(matcher.find())
        {
            day[counter] = matcher.group(0);
            counter++;
        }

        for(int i =0; i<5; i++)
        {
          store = day[i];
          dayInfo[i][0] = store.substring(store.indexOf("day") + 5, store.indexOf("date") - 2);
          dayInfo[i][1] = store.substring(store.indexOf("text") + 6, store.indexOf("code") - 2);
        }
    }
    
    public static String getCurrentDate()
    {
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateString = dateformat.format(date);
        
        return dateString;
    }
    
  
}