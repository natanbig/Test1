package il.qa.openweathermap.helpers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import il.qa.openweathermap.appmanager.ApplicationManager;
import il.qa.openweathermap.dataModel.CityData;

import java.util.List;

public class JsonExtractorHelper {
  private String json;
  private JsonElement cityName;
  private JsonElement sunriseTimeUNX;
  private JsonElement sunsetTimeUNX;
  private JsonElement temperatureKelvin;
  private JsonElement parsedJson;

  public String getJson() {
    return json;
  }

  public String getCityName() {
    return cityName.toString();
  }

  public int getSunriseTimeUNX() {
    return Integer.parseInt(sunriseTimeUNX.toString());
  }

  public int getSunsetTimeUNX() {
    return Integer.parseInt(sunsetTimeUNX.toString());
  }

  public float getTemperatureKelvin() {
    return Float.parseFloat(temperatureKelvin.toString());
  }



  public void extractRequiredDataFromCityJson(String json){
    parsedJson= new JsonParser().parse(json);
    cityName=parsedJson.getAsJsonObject().get("name");
    sunriseTimeUNX=parsedJson.getAsJsonObject().get("sys").getAsJsonObject().get("sunrise");
    sunsetTimeUNX=parsedJson.getAsJsonObject().get("sys").getAsJsonObject().get("sunset");
    temperatureKelvin=parsedJson.getAsJsonObject().get("main").getAsJsonObject().get("temp");
  }


}
