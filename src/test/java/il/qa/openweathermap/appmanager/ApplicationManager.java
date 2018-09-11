package il.qa.openweathermap.appmanager;

import il.qa.openweathermap.helpers.HttpSession;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
  private final Properties webProperties = new Properties();
  private final Properties citiesList = new Properties();


  public void init() throws IOException{
    webProperties.load(new FileReader(new File(String.format("src\\test\\resources\\web.Properties"))));
    citiesList.load(new FileReader(new File(String.format("src\\test\\resources\\cities.properties"))));
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
}
