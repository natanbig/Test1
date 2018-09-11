package il.qa.openweathermap.appmanager;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import il.qa.openweathermap.dataModel.CityData;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

public class HttpSession {
  private ApplicationManager app;

  public HttpSession(ApplicationManager app){
    this.app=app;
  }

  public List<CityData> getData() throws IOException {
    String json;
    List<CityData> cityDataSet = new ArrayList<>();
    for(int i =1;i<11;i++) {
      json = Request.Get(app.getWebProperty("web.baseUrl") + URLEncoder.encode(app.getCitiesList((String.format("city.%s", i)))) + "&APPID=" + app.getWebProperty("web.apiKey.currentWheather"))
              .execute().returnContent().asString();
      JsonElement parsedJson = new JsonParser().parse(json);

      JsonElement cityName=parsedJson.getAsJsonObject().get("name");
      JsonElement sunriseTimeUNX=parsedJson.getAsJsonObject().get("sys").getAsJsonObject().get("sunrise");
      JsonElement sunsetTimeUNX=parsedJson.getAsJsonObject().get("sys").getAsJsonObject().get("sunset");
      JsonElement temperatureKelvin=parsedJson.getAsJsonObject().get("main").getAsJsonObject().get("temp");
       cityDataSet.add(new CityData(
              cityName.toString(),
              Integer.parseInt(sunriseTimeUNX.toString()),
              Integer.parseInt(sunsetTimeUNX.toString()),
              Float.parseFloat(temperatureKelvin.toString())));

    }
    return cityDataSet;
  }

}
