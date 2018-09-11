package il.qa.openweathermap.tests;

import il.qa.openweathermap.appmanager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager();

  @BeforeSuite
  public void setUp() throws Exception{
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }
}
