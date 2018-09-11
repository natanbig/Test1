package il.qa.openweathermap.helpers;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import il.qa.openweathermap.appmanager.ApplicationManager;
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

  public List<CityData> getCitiesList() throws IOException {
    List<CityData> citiDataList = new ArrayList<>();
    for(int i =1;i<11;i++) {
      String json = Request.Get(app.getWebProperty("web.baseUrl") + URLEncoder.encode(app.getCitiesList((String.format("city.%s", i)))) + "&APPID=" + app.getWebProperty("web.apiKey.currentWheather"))
              .execute().returnContent().asString();

       app.jsonElements().extractRequiredDataFromCityJson(json);
       citiDataList.add(new CityData(
                              app.jsonElements().getCityName(),
                              app.jsonElements().getSunriseTimeUNX(),
                              app.jsonElements().getSunsetTimeUNX(),
                              app.jsonElements().getTemperatureKelvin()
       ));

    }
    return citiDataList;
  }

}
