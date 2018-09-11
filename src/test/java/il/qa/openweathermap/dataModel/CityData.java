package il.qa.openweathermap.dataModel;

import java.util.Objects;

public class CityData {

  private String cityName;
  private int sunriseTimeUNX;
  private int sunsetTimeUNX;
  private float temperatureKelvin;
  private int daylight;



  public CityData(String cityName, int sunriseTimeUNX, int sunsetTimeUNX, float temperatureKelvin) {

    this.cityName = cityName;
    this.sunriseTimeUNX = sunriseTimeUNX;
    this.sunsetTimeUNX = sunsetTimeUNX;
    this.temperatureKelvin = temperatureKelvin;
    this.daylight=sunsetTimeUNX-sunriseTimeUNX;

  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("CityData{");
    sb.append("cityName='").append(cityName).append('\'');
    sb.append(", sunriseTimeUNX=").append(sunriseTimeUNX);
    sb.append(", sunsetTimeUNX=").append(sunsetTimeUNX);
    sb.append(", temperatureKelvin=").append(temperatureKelvin);
    sb.append(", daylight=").append(daylight);
    sb.append('}');
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CityData cityData = (CityData) o;
    return daylight == cityData.daylight;
  }

  @Override
  public int hashCode() {

    return Objects.hash(daylight);
  }

  public CityData() {

  }

  public String getCityName() {
    return cityName;
  }

  public int getSunriseTimeUNX() {
    return sunriseTimeUNX;
  }

  public int getSunsetTimeUNX() {
    return sunsetTimeUNX;
  }

  public float getTemperatureKelvin() {
    return temperatureKelvin;
  }
  public int getDaylight() {
    return daylight;
  }

}