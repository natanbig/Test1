package il.qa.openweathermap.tests;

import il.qa.openweathermap.dataModel.CityData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindLongestAndShortestDayLightCity extends  TestBase {


  @Test
  public void findLongestandShortestDaulight() throws IOException {

    //----------Pull elements from site to collection cityData----------------//
    List<CityData> cityData = app.newSession().getCitiesList();

    //Finds in cityData collection maximum and minimum daylight values
    String cityNameOfLongestDaylight=cityData.stream().max(Comparator.comparingInt(CityData::getDaylight)).get().getCityName();
    String cityNameOfShortestDaylight=cityData.stream().min(Comparator.comparingInt(CityData::getDaylight)).get().getCityName();

    //Returns two objects that including maximum and minimum values
    List<CityData> longestDaylight=cityData.stream().filter(o -> cityNameOfLongestDaylight.equals(o.getCityName())).collect(Collectors.toList());
    List<CityData> shortestDaylight=cityData.stream().filter(o -> cityNameOfShortestDaylight.equals(o.getCityName())).collect(Collectors.toList());

    //Outputs the temperature of the shortest and longest daylight time city
    System.out.println("The longest daylight in " +longestDaylight.get(0).getCityName()+ " with temperature " + longestDaylight.get(0).getTemperatureKelvin()+"\n");
    System.out.println("The longest daylight in " +shortestDaylight.get(0).getCityName()+ " with temperature " + shortestDaylight.get(0).getTemperatureKelvin()+"\n");

  }
}
