import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;

//30, 100 coord for main icon
//50 ,440 first set of future data
//230, 440 second set
//410, 440 third set
//590, 440 fourth set

public abstract class WeatherPanel extends JPanel {

    public WeatherPanel () {
        setSize(800, 600);
    }

    private Image dayBackgroundInit = new ImageIcon("dayBG.png").getImage();
    private Image dayBackground = dayBackgroundInit.getScaledInstance(800, 600, 0);
    private Image nightBackgroundInit = new ImageIcon("nightBG.png").getImage();
    private Image nightBackground = nightBackgroundInit.getScaledInstance(800, 600, 0);
    private Image clearSkyIconInit = new ImageIcon("Icons/Clear.png").getImage();
    private Image clearSkyIcon = clearSkyIconInit.getScaledInstance(200, 200, 0);
    private Image clearSkyIconSmall = clearSkyIconInit.getScaledInstance(85, 85, 0);
    private Image nightClearIconInit = new ImageIcon("Icons/nightClear.png").getImage();
    private Image nightClearIcon = nightClearIconInit.getScaledInstance(200, 200, 0);
    private Image nightClearIconSmall = nightClearIconInit.getScaledInstance(85, 85, 0);
    private Image thunderStormIconInit = new ImageIcon("Icons/thunderStorm.png").getImage();
    private Image thunderStormIcon = thunderStormIconInit.getScaledInstance(200, 200, 0);
    private Image thunderStormIconSmall = thunderStormIconInit.getScaledInstance(85, 85, 0);
    private Image cloudyIconInit = new ImageIcon("Icons/Cloudy.png").getImage();
    private Image cloudyIcon = cloudyIconInit.getScaledInstance(200, 200, 0);
    private Image cloudyIconSmall = cloudyIconInit.getScaledInstance(85, 85, 0);
    private Image partlyCloudyIconInit = new ImageIcon("Icons/partlyCloudy.png").getImage();
    private Image partlyCloudyIcon = partlyCloudyIconInit.getScaledInstance(200, 200, 0);
    private Image partlyCloudyIconSmall = partlyCloudyIconInit.getScaledInstance(85, 85, 0);
    private Image rainIconInit = new ImageIcon("Icons/Rain.png").getImage();
    private Image rainIcon = rainIconInit.getScaledInstance(200, 200, 0);
    private Image rainIconSmall = rainIconInit.getScaledInstance(85, 85, 0);
    private Image snowIconInit = new ImageIcon("Icons/Snow.png").getImage();
    private Image snowIcon = snowIconInit.getScaledInstance(200, 200, 0);
    private Image snowIconSmall = snowIconInit.getScaledInstance(85, 85, 0);
    private Image nightCloudIconInit = new ImageIcon("Icons/nightClouds.png").getImage();
    private Image nightCloudIcon = nightCloudIconInit.getScaledInstance(200, 200, 0);
    private Image nightCloudIconSmall = nightCloudIconInit.getScaledInstance(85, 85, 0);


    public void paintComponent (Graphics g) {
        try {
            Data.update();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.paintComponent(g);
        //These 2 if statements change background based on if its close to or during the day or
        //during the evening and night time, this is using 24 hour time
        if (Data.newTime < 20 || Data.newTime >= 6) {
            g.drawImage(dayBackground, 0, 0, this);
        }
        if (Data.newTime >= 20 || Data.newTime < 6) {
            g.drawImage(nightBackground, 0, 0, this);
        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("VERDANA", Font.BOLD, 50));
        g.drawString(Integer.toString(Data.currentTemp) + " C", 250, 150);
        g.setFont(new Font("VERDANA", Font.PLAIN, 15));
        g.drawString("o", 325, 110);
        g.drawRect(50, 400, 700, 4);
        g.fillRect(50, 400, 700, 4);
        g.setFont(new Font("VERDANA", Font.PLAIN, 15));
        g.drawString("Low: " + Integer.toString(Data.minTemp), 50, 250);
        g.drawString(" | ", 122, 250);
        g.drawString("High: " + Integer.toString(Data.maxTemp), 150, 250);
        g.setFont(new Font("VERDANA", Font.PLAIN, 25));
        g.drawString(String.format("Wind: %.1f KM/H %s",Data.windSpeed, Data.windDirection), 50, 350);
        g.drawString("Clouds: " + Integer.toString(Data.clouds) + "%", 550, 350);
        g.drawString(Data.weatherDesc, 50, 300);
        g.setFont(new Font("VERDANA", Font.PLAIN, 20));
        g.drawString("FUTURE FORECAST", 275, 390);
        g.setFont(new Font("VERDANA", Font.BOLD, 13));
        //time for future data
        g.drawString("3 Hours", 60, 430);
        g.drawString("6 Hours", 240, 430);
        g.drawString("9 Hours", 420, 430);
        g.drawString("12 Hours", 600, 430);
        //future weather descriptions
        g.setFont(new Font("VERDANA", Font.PLAIN, 15));
        g.drawString(Data.weatherDesc2, 60, 550);
        g.drawString(Data.weatherDesc3, 240, 550);
        g.drawString(Data.weatherDesc4, 420, 550);
        g.drawString(Data.weatherDesc5, 600, 550);
        //set 1
        g.drawString(Integer.toString(Data.maxTemp2), 160, 460);
        g.drawString(Integer.toString(Data.currentTemp2), 160, 485);
        g.drawString(Integer.toString(Data.minTemp2), 160, 510);
        //set 2
        g.drawString(Integer.toString(Data.maxTemp3), 340, 460);
        g.drawString(Integer.toString(Data.currentTemp3), 340, 485);
        g.drawString(Integer.toString(Data.minTemp3), 340, 510);
        //set 3
        g.drawString(Integer.toString(Data.maxTemp4), 520, 460);
        g.drawString(Integer.toString(Data.currentTemp4), 520, 485);
        g.drawString(Integer.toString(Data.minTemp4), 520, 510);
        //set 4
        g.drawString(Integer.toString(Data.maxTemp4), 700, 460);
        g.drawString(Integer.toString(Data.currentTemp4), 700, 485);
        g.drawString(Integer.toString(Data.minTemp4), 700, 510);
        //dividers for temperature
        g.setFont(new Font("VERDANA", Font.PLAIN, 20));
        g.drawString("__", 157, 465);
        g.drawString("__", 157, 490);
        g.drawString("__", 337, 465);
        g.drawString("__", 337, 490);
        g.drawString("__", 517, 465);
        g.drawString("__", 517, 490);
        g.drawString("__", 697, 465);
        g.drawString("__", 697, 490);
        //City name
        g.setFont(new Font("VERDANA", Font.PLAIN, 30));
        g.drawString(Data.cityName, 650, 50);
        if (Data.newTime > 12) {
            g.drawString(Integer.toString(Tools.time12Hr(Data.newTime)) + " PM", 650, 100);
        } else {
            g.drawString(Integer.toString(Tools.time12Hr(Data.newTime)) + " AM", 650, 100);
        }

        //Parsing for storm weather conditions and setting proper icons
        for (String s : Data.weatherCondThunder) {
            if (s.equals(Data.weatherDesc)) {
                g.drawImage(thunderStormIcon, 30, 50, this);
            }
            if (s.equals(Data.weatherDesc2)) {
                g.drawImage(thunderStormIconSmall, 50, 440, this);
            }
            if (s.equals(Data.weatherDesc3)) {
                g.drawImage(thunderStormIconSmall, 230, 440, this);
            }
            if (s.equals(Data.weatherDesc4)) {
                g.drawImage(thunderStormIconSmall, 410, 440, this);
            }
            if (s.equals(Data.weatherDesc5)) {
                g.drawImage(thunderStormIconSmall, 590, 440, this);
            }
        }

        //Parsing for rainy weather conditions and setting proper icons
        for (String s : Data.weatherCondRain) {
            if (s.equals(Data.weatherDesc)) {
                g.drawImage(rainIcon, 30, 50, this);
            }
            if (s.equals(Data.weatherDesc2)) {
                g.drawImage(rainIconSmall, 50, 440, this);
            }
            if (s.equals(Data.weatherDesc3)) {
                g.drawImage(rainIconSmall, 230, 440, this);
            }
            if (s.equals(Data.weatherDesc4)) {
                g.drawImage(rainIconSmall, 410, 440, this);
            }
            if (s.equals(Data.weatherDesc5)) {
                g.drawImage(rainIconSmall, 590, 440, this);
            }
        }
        //Parsing for cloudy weather conditions and setting proper icons
        for (String s : Data.weatherCondClouds) {
            if (s.equals(Data.weatherDesc)) {
                g.drawImage(cloudyIcon, 30, 50, this);
            }
            if (s.equals(Data.weatherDesc2)) {
                g.drawImage(cloudyIconSmall, 50, 440, this);
            }
            if (s.equals(Data.weatherDesc3)) {
                g.drawImage(cloudyIconSmall, 230, 440, this);
            }
            if (s.equals(Data.weatherDesc4)) {
                g.drawImage(cloudyIconSmall, 410, 440, this);
            }
            if (s.equals(Data.weatherDesc5)) {
                g.drawImage(cloudyIconSmall, 590, 440, this);
            }

        }

        //Parsing for snow weather conditions and setting proper icons
        for (String s : Data.weatherCondSnow) {
            if (s.equals(Data.weatherDesc)) {
                g.drawImage(snowIcon, 30, 50, this);
            }
            if (s.equals(Data.weatherDesc2)) {
                g.drawImage(snowIconSmall, 50, 440, this);
            }
            if (s.equals(Data.weatherDesc3)) {
                g.drawImage(snowIconSmall, 230, 440, this);
            }
            if (s.equals(Data.weatherDesc4)) {
                g.drawImage(snowIconSmall, 410, 440, this);
            }
            if (s.equals(Data.weatherDesc5)) {
                g.drawImage(snowIconSmall, 590, 440, this);
            }

        }

        //Daytime icons get used
        if (Data.newTime < 20) {
            if (Data.newTime > 6) {
                if (Data.weatherDesc.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIcon, 30, 50, this);
                }
                if (Data.weatherDesc.equals("few clouds")) {
                    g.drawImage(partlyCloudyIcon, 30, 50, this);
                }
                if (Data.weatherDesc.equals("clear sky")) {
                    g.drawImage(clearSkyIcon, 30 ,50, this);
                }
            }
        }
        if (Data.newTime > 6) {
            if (Data.newTime < 20) {
                if (Data.weatherDesc.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIcon, 30, 50, this);
                }
                if (Data.weatherDesc.equals("few clouds")) {
                    g.drawImage(partlyCloudyIcon, 30, 50, this);
                }
                if (Data.weatherDesc.equals("clear sky")) {
                    g.drawImage(clearSkyIcon, 30, 50, this);
                }
            }
        }
        //nighttime icons get used
        if (Data.newTime < 6) {
            if (Data.weatherDesc.equals("scattered clouds")) {
                g.drawImage(nightCloudIcon, 30, 50, this);
            }
            if (Data.weatherDesc.equals("few clouds")) {
                g.drawImage(nightCloudIcon, 30, 50, this);
            }
            if (Data.weatherDesc.equals("clear sky")) {
                g.drawImage(nightClearIcon, 30, 50, this);
            }
        }
        if (Data.newTime > 20) {
            if (Data.weatherDesc.equals("scattered clouds")) {
                g.drawImage(nightCloudIcon, 30, 50, this);
            }
            if (Data.weatherDesc.equals("few clouds")) {
                g.drawImage(nightCloudIcon, 30, 50, this);
            }
            if (Data.weatherDesc.equals("clear sky")) {
                g.drawImage(nightClearIcon, 30, 50, this);
            }
        }
        //night time icons get used
        if (Data.newTime == 20) {
            if (Data.weatherDesc.equals("scattered clouds")) {
                g.drawImage(nightCloudIcon, 30, 50, this);
            }
            if (Data.weatherDesc.equals("few clouds")) {
                g.drawImage(nightCloudIcon, 30, 50, this);
            }
            if (Data.weatherDesc.equals("clear sky")) {
                g.drawImage(nightClearIcon, 30, 50, this);
            }
        }
        //daytime icons get used
        if (Data.newTime == 6) {
            if (Data.weatherDesc.equals("scattered clouds")) {
                g.drawImage(partlyCloudyIcon, 30, 50, this);
            }
            if (Data.weatherDesc.equals("few clouds")) {
                g.drawImage(partlyCloudyIcon, 30, 50, this);
            }
            if (Data.weatherDesc.equals("clear sky")) {
                g.drawImage(clearSkyIcon, 30 ,50, this);
            }
        }
//----------------------------------------------------------------FUTURE WEATHER CONDITIONS------------------------------------------------------------------------------
       //same being repeated for all the rest as above code
        //has to be done because it is 5 different icons always displayed on screen depending on weather conditions
        if (Data.newTime2 < 20) {
            if (Data.newTime2 > 6) {
                if (Data.weatherDesc2.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 50, 440, this);
                }
                if (Data.weatherDesc2.equals("few clouds")) {
                    g.drawImage(partlyCloudyIcon, 50, 440, this);
                }
                if (Data.weatherDesc2.equals("clear sky")) {
                    g.drawImage(clearSkyIcon, 50 ,440, this);
                }
            }
        }
        if (Data.newTime2 > 6) {
            if (Data.newTime2 < 20) {
                if (Data.weatherDesc2.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 50, 440, this);
                }
                if (Data.weatherDesc2.equals("few clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 50, 440, this);
                }
                if (Data.weatherDesc2.equals("clear sky")) {
                    g.drawImage(clearSkyIconSmall, 50 ,440, this);
                }
            }
        }
        if (Data.newTime2 < 6) {
            if (Data.weatherDesc2.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 50, 440, this);
            }
            if (Data.weatherDesc2.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 50, 440, this);
            }
            if (Data.weatherDesc2.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 50, 440, this);
            }
        }
        if (Data.newTime2 > 20) {
            if (Data.weatherDesc2.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 50, 440, this);
            }
            if (Data.weatherDesc2.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 50, 440, this);
            }
            if (Data.weatherDesc2.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 50, 440, this);
            }
        }
        if (Data.newTime2 == 20) {
            if (Data.weatherDesc2.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 50, 440, this);
            }
            if (Data.weatherDesc2.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 50, 440, this);
            }
            if (Data.weatherDesc2.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 50, 440, this);
            }
        }
        if (Data.newTime2 == 6) {
            if (Data.weatherDesc2.equals("scattered clouds")) {
                g.drawImage(partlyCloudyIconSmall, 50, 440, this);
            }
            if (Data.weatherDesc2.equals("few clouds")) {
                g.drawImage(partlyCloudyIconSmall, 50, 440, this);
            }
            if (Data.weatherDesc2.equals("clear sky")) {
                g.drawImage(clearSkyIconSmall, 50 ,440, this);
            }
        }


        if (Data.newTime3 < 20) {
            if (Data.newTime3 > 6) {
                if (Data.weatherDesc3.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 230, 440, this);
                }
                if (Data.weatherDesc3.equals("few clouds")) {
                    g.drawImage(partlyCloudyIcon, 230, 440, this);
                }
                if (Data.weatherDesc3.equals("clear sky")) {
                    g.drawImage(clearSkyIcon, 230 ,440, this);
                }
            }
        }
        if (Data.newTime3 > 6) {
            if (Data.newTime3 < 20) {
                if (Data.weatherDesc3.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 230, 440, this);
                }
                if (Data.weatherDesc3.equals("few clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 230, 440, this);
                }
                if (Data.weatherDesc3.equals("clear sky")) {
                    g.drawImage(clearSkyIconSmall, 230 ,440, this);
                }
            }
        }
        if (Data.newTime3 < 6) {
            if (Data.weatherDesc3.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 230, 440, this);
            }
            if (Data.weatherDesc3.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 230, 440, this);
            }
            if (Data.weatherDesc3.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 230, 440, this);
            }
        }
        if (Data.newTime3 > 20) {
            if (Data.weatherDesc3.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 230, 440, this);
            }
            if (Data.weatherDesc3.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 230, 440, this);
            }
            if (Data.weatherDesc3.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 230, 440, this);
            }
        }
        if (Data.newTime3 == 20) {
            if (Data.weatherDesc3.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 230, 440, this);
            }
            if (Data.weatherDesc3.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 230, 440, this);
            }
            if (Data.weatherDesc3.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 230, 440, this);
            }
        }
        if (Data.newTime3 == 6) {
            if (Data.weatherDesc3.equals("scattered clouds")) {
                g.drawImage(partlyCloudyIconSmall, 230, 440, this);
            }
            if (Data.weatherDesc3.equals("few clouds")) {
                g.drawImage(partlyCloudyIconSmall, 230, 440, this);
            }
            if (Data.weatherDesc3.equals("clear sky")) {
                g.drawImage(clearSkyIconSmall, 230 ,440, this);
            }
        }


        if (Data.newTime4 < 20) {
            if (Data.newTime4 > 6) {
                if (Data.weatherDesc4.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 410, 440, this);
                }
                if (Data.weatherDesc4.equals("few clouds")) {
                    g.drawImage(partlyCloudyIcon, 410, 440, this);
                }
                if (Data.weatherDesc4.equals("clear sky")) {
                    g.drawImage(clearSkyIcon, 410 ,440, this);
                }
            }
        }
        if (Data.newTime4 > 6) {
            if (Data.newTime4 < 20) {
                if (Data.weatherDesc4.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 410, 440, this);
                }
                if (Data.weatherDesc4.equals("few clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 410, 440, this);
                }
                if (Data.weatherDesc4.equals("clear sky")) {
                    g.drawImage(clearSkyIconSmall, 410 ,440, this);
                }
            }
        }
        if (Data.newTime4 < 6) {
            if (Data.weatherDesc4.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 410, 440, this);
            }
            if (Data.weatherDesc4.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 410, 440, this);
            }
            if (Data.weatherDesc4.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 410, 440, this);
            }
        }
        if (Data.newTime4 > 20) {
            if (Data.weatherDesc4.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 410, 440, this);
            }
            if (Data.weatherDesc4.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 410, 440, this);
            }
            if (Data.weatherDesc4.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 410, 440, this);
            }
        }
        if (Data.newTime4 == 20) {
            if (Data.weatherDesc4.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 410, 440, this);
            }
            if (Data.weatherDesc4.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 410, 440, this);
            }
            if (Data.weatherDesc4.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 410, 440, this);
            }
        }
        if (Data.newTime4 == 6) {
            if (Data.weatherDesc4.equals("scattered clouds")) {
                g.drawImage(partlyCloudyIconSmall, 410, 440, this);
            }
            if (Data.weatherDesc4.equals("few clouds")) {
                g.drawImage(partlyCloudyIconSmall, 410, 440, this);
            }
            if (Data.weatherDesc4.equals("clear sky")) {
                g.drawImage(clearSkyIconSmall, 410 ,440, this);
            }
        }


        if (Data.newTime5 < 20) {
            if (Data.newTime5 > 6) {
                if (Data.weatherDesc5.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 590, 440, this);
                }
                if (Data.weatherDesc5.equals("few clouds")) {
                    g.drawImage(partlyCloudyIcon, 590, 440, this);
                }
                if (Data.weatherDesc5.equals("clear sky")) {
                    g.drawImage(clearSkyIconSmall, 590 ,440, this);
                }
            }
        }
        if (Data.newTime5 > 6) {
            if (Data.newTime5 < 20) {
                if (Data.weatherDesc5.equals("scattered clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 590, 440, this);
                }
                if (Data.weatherDesc5.equals("few clouds")) {
                    g.drawImage(partlyCloudyIconSmall, 590, 440, this);
                }
                if (Data.weatherDesc5.equals("clear sky")) {
                    g.drawImage(clearSkyIconSmall, 590 ,440, this);
                }
            }
        }
        if (Data.newTime5 < 6) {
            if (Data.weatherDesc5.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 590, 440, this);
            }
            if (Data.weatherDesc5.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 590, 440, this);
            }
            if (Data.weatherDesc5.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 590, 440, this);
            }
        }
        if (Data.newTime5 > 20) {
            if (Data.weatherDesc5.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 590, 440, this);
            }
            if (Data.weatherDesc5.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 590, 440, this);
            }
            if (Data.weatherDesc5.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 590, 440, this);
            }
        }
        if (Data.newTime5 == 20) {
            if (Data.weatherDesc5.equals("scattered clouds")) {
                g.drawImage(nightCloudIconSmall, 590, 440, this);
            }
            if (Data.weatherDesc5.equals("few clouds")) {
                g.drawImage(nightCloudIconSmall, 590, 440, this);
            }
            if (Data.weatherDesc5.equals("clear sky")) {
                g.drawImage(nightClearIconSmall, 590, 440, this);
            }
        }
        if (Data.newTime5 == 6) {
            if (Data.weatherDesc5.equals("scattered clouds")) {
                g.drawImage(partlyCloudyIconSmall, 590, 440, this);
            }
            if (Data.weatherDesc5.equals("few clouds")) {
                g.drawImage(partlyCloudyIconSmall, 590, 440, this);
            }
            if (Data.weatherDesc5.equals("clear sky")) {
                g.drawImage(clearSkyIconSmall, 590 ,440, this);
            }
        }
    }
}