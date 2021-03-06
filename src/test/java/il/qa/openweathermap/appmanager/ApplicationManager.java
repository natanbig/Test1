package il.qa.openweathermap.appmanager;

import il.qa.openweathermap.helpers.HttpSession;
import il.qa.openweathermap.helpers.JsonExtractorHelper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class ApplicationManager {
  private final Properties webProperties = new Properties();
  private final Properties citiesList = new Properties();
  private JsonExtractorHelper jsonExtractorHelper = new JsonExtractorHelper();



  public void init() throws IOException{
    ClassLoader classLoader=getClass().getClassLoader();
    webProperties.load(new FileReader(new File(URLDecoder.decode(classLoader.getResource("web.properties").getFile()))));
    citiesList.load(new FileReader(new File(URLDecoder.decode(classLoader.getResource("cities.properties").getFile()))));


}

  public void stop(){

  }

  public HttpSession newSession(){
    return new HttpSession(this);
  }

  public String getCitiesList(String key) {
    return citiesList.getProperty(key);
  }

  public String getWebProperty(String key) {
    return webProperties.getProperty(key);
  }

  public JsonExtractorHelper jsonElements() {
    return jsonExtractorHelper;
  }
}
