import java.io.IOException;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.HourlyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;
import net.aksingh.owmjapis.OpenWeatherMap.Units;
//API Key is 99485163cd9417789b59e7c7165e573e
//All getter methods to get data in this class are from the API
//i manipulated the data to what I needed and what looked better, rounding up decimals or converting from double to int

public class Data {

    //have 5 different variations for variables due to 5 different forecasts being shown
    //main one for current time at top, then future forecast with 4 pieces of data

    public static int maxTemp, maxTemp2, maxTemp3, maxTemp4, maxTemp5;
    public static int minTemp, minTemp2, minTemp3, minTemp4, minTemp5;
    public static int currentTemp, currentTemp2, currentTemp3, currentTemp4, currentTemp5;
    public static int clouds;
    public static String weatherDesc, weatherDesc2, weatherDesc3, weatherDesc4, weatherDesc5;
    public static double windSpeed;
    public static String windDirection;
    public static String time, time2, time3, time4, time5;
    public static String cityName;
    public static int hour, hour2, hour3, hour4, hour5;
    public static int newTime, newTime2, newTime3, newTime4, newTime5;
    public static String[] weatherCondThunder;
    public static String[] weatherCondRain;
    public static String[] weatherCondSnow;
    public static String[] weatherCondClouds;





    public static void update() throws IOException, JSONException{
        // declaring object of "OpenWeatherMap" class and setting metric units
        OpenWeatherMap.Units units = Units.METRIC;
        OpenWeatherMap owm = new OpenWeatherMap(units, "99485163cd9417789b59e7c7165e573e");
        // getting current weather data for the city
        CurrentWeather cwd = owm.currentWeatherByCityName("Dallas");
        Float geoCoordLat = cwd.getCoordInstance().getLatitude();
        Float geoCoordLon = cwd.getCoordInstance().getLongitude();
        HourlyForecast hf = owm.hourlyForecastByCoordinates(geoCoordLat , geoCoordLon);
        int hourlyForecastIndex = 0;    //weather data for the current time
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MAIN DATA~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        if (hf.isValid()) {//checks if hourly forecast data was found
            cityName = hf.getCityInstance().getCityName();

            if (hf.getForecastInstance(hourlyForecastIndex).hasMainInstance()) {
                maxTemp = (int) (hf.getForecastInstance(hourlyForecastIndex).getMainInstance().getMaxTemperature());
                currentTemp = (int) (hf.getForecastInstance(hourlyForecastIndex).getMainInstance().getTemperature());
                minTemp = (int) (hf.getForecastInstance(hourlyForecastIndex).getMainInstance().getMinTemperature());
                weatherDesc = hf.getForecastInstance(hourlyForecastIndex).getWeatherInstance(0).getWeatherDescription();
                time = hf.getForecastInstance(hourlyForecastIndex).getDateTimeText();

            }
            if (hf.getForecastInstance(hourlyForecastIndex).hasCloudsInstance()) {
                clouds = (int) (hf.getForecastInstance(hourlyForecastIndex).getCloudsInstance().getPercentageOfClouds());
            }
            if (hf.getForecastInstance(hourlyForecastIndex).hasWindInstance()) {
                windSpeed = Double.parseDouble(hf.getForecastInstance(hourlyForecastIndex).getWindInstance().getWindSpeed()*3.6 + "");
                windDirection = Tools.Direction(hf.getForecastInstance(hourlyForecastIndex).getWindInstance().getWindDegree());
            }
            hour = Integer.parseInt(time.split(" ")[1].replaceAll(" ","").substring(0,2));

            //Bottom If/Else statement changes time from UTC to EDT so time is accurate for windsor.

            newTime = hour - 4;
            if (newTime < 0) {
                newTime = 24 + hour - 4;
            }



//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~FUTURE FORECAST DATA~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            if (hf.getForecastInstance(1).hasMainInstance()) {
                maxTemp2 = (int) (hf.getForecastInstance(1).getMainInstance().getMaxTemperature());
                currentTemp2 = (int) (hf.getForecastInstance(1).getMainInstance().getTemperature());
                minTemp2 = (int) (hf.getForecastInstance(1).getMainInstance().getMinTemperature());
                weatherDesc2 = hf.getForecastInstance(1).getWeatherInstance(0).getWeatherDescription();
                time2 = hf.getForecastInstance(1).getDateTimeText();

            }

            hour2 = Integer.parseInt(time2.split(" ")[1].replaceAll(" ","").substring(0,2));
            if (newTime2 < 0) {
                newTime2 = 24 + hour2 - 4;
            } else {
                newTime2 = hour2 - 4;
            }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            if (hf.getForecastInstance(2).hasMainInstance()) {
                maxTemp3 = (int) (hf.getForecastInstance(2).getMainInstance().getMaxTemperature());
                currentTemp3 = (int) (hf.getForecastInstance(2).getMainInstance().getTemperature());
                minTemp3 = (int) (hf.getForecastInstance(2).getMainInstance().getMinTemperature());
                weatherDesc3 = hf.getForecastInstance(2).getWeatherInstance(0).getWeatherDescription();
                time3 = hf.getForecastInstance(2).getDateTimeText();
            }

            hour3 = Integer.parseInt(time3.split(" ")[1].replaceAll(" ","").substring(0,2));
            if (newTime3 < 0) {
                newTime3 = 24 + hour3 - 4;
            } else {
                newTime3 = hour3 - 4;
            }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            if (hf.getForecastInstance(3).hasMainInstance()) {
                maxTemp4 = (int) (hf.getForecastInstance(3).getMainInstance().getMaxTemperature());
                currentTemp4 = (int) (hf.getForecastInstance(3).getMainInstance().getTemperature());
                minTemp4 = (int) (hf.getForecastInstance(3).getMainInstance().getMinTemperature());
                weatherDesc4 = hf.getForecastInstance(3).getWeatherInstance(0).getWeatherDescription();
                time4 = hf.getForecastInstance(hourlyForecastIndex).getDateTimeText();
            }

            hour4 = Integer.parseInt(time4.split(" ")[1].replaceAll(" ","").substring(0,2));
            if (newTime4 < 0) {
                newTime4 = 24 + hour4 - 4;
            } else {
                newTime4 = hour4 - 4;
            }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

            if (hf.getForecastInstance(4).hasMainInstance()) {
                maxTemp5 = (int) (hf.getForecastInstance(4).getMainInstance().getMaxTemperature());
                currentTemp5 = (int) (hf.getForecastInstance(4).getMainInstance().getTemperature());
                minTemp5 = (int) (hf.getForecastInstance(4).getMainInstance().getMinTemperature());
                weatherDesc5 = hf.getForecastInstance(4).getWeatherInstance(0).getWeatherDescription();
                time5 = hf.getForecastInstance(hourlyForecastIndex).getDateTimeText();
            }

            hour5 = Integer.parseInt(time5.split(" ")[1].replaceAll(" ","").substring(0,2));
            if (newTime5 < 0) {
                newTime5 = 24 + hour5 - 4;
            } else {
                newTime5 = hour5 - 4;
            }
        }
        //for if there are weather conditions involving thunderstorms
        weatherCondThunder = new String[10];
        weatherCondThunder[0] = "thunderstorm with light rain";
        weatherCondThunder[1] = "thunderstorm with rain";
        weatherCondThunder[2] = "thunderstorm with heavy rain";
        weatherCondThunder[3] = "light thunderstorm";
        weatherCondThunder[4] = "thunderstorm";
        weatherCondThunder[5] = "heavy thunderstorm";
        weatherCondThunder[6] = "ragged thunderstorm";
        weatherCondThunder[7] = "thunderstorm with light drizzle";
        weatherCondThunder[8] = "thunderstorm with drizzle";
        weatherCondThunder[9] = "thunderstorm with heavy drizzle";

        //for if there are weather conditions involving drizzle/rain
        weatherCondRain= new String[19];
        weatherCondRain[0] = "light intensity drizzle";
        weatherCondRain[1] = "drizzle";
        weatherCondRain[2] = "heavy intensity drizzle";
        weatherCondRain[3] = "light intensity drizzle rain";
        weatherCondRain[4] = "drizzle rain";
        weatherCondRain[5] = "heavy intensity drizzle rain";
        weatherCondRain[6] = "shower rain and drizzle";
        weatherCondRain[7] = "heavy shower rain and drizzle";
        weatherCondRain[8] = "shower drizzle";
        weatherCondRain[9] = "light rain";
        weatherCondRain[10] = "moderate rain";
        weatherCondRain[11] = "heavy intensity rain";
        weatherCondRain[12] = "very heavy rain";
        weatherCondRain[13] = "extreme rain";
        weatherCondRain[14] = "freezing rain";
        weatherCondRain[15] = "light intensity shower rain";
        weatherCondRain[16] = "shower rain";
        weatherCondRain[17] = "heavy intensity shower rain";
        weatherCondRain[18] = "ragged shower rain";

        //for if there are any weather conditions involving snow
        weatherCondSnow = new String[10];
        weatherCondSnow[0] = "light snow";
        weatherCondSnow[1] = "snow";
        weatherCondSnow[2] = "heavy snow";
        weatherCondSnow[3] = "sleet";
        weatherCondSnow[4] = "shower sleet";
        weatherCondSnow[5] = "light rain and snow";
        weatherCondSnow[6] = "rain and snow";
        weatherCondSnow[7] = "light shower snow";
        weatherCondSnow[8] = "shower snow";
        weatherCondSnow[9] = "heavy shower snow";

        //for some weather conditions involving clouds
        weatherCondClouds = new String[2];
        weatherCondClouds[0] = "broken clouds";
        weatherCondClouds[1] = "overcast clouds";

    }
}