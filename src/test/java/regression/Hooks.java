package regression;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    DriverManager driverManager = new DriverManager();

    @Before
    public void setUp()
    {
        driverManager.openBrowser("chrome");
        driverManager.maxBrowser();
        driverManager.implicitWait(10);
    }

    @After
    public void tearDown()
    {
        driverManager.closeBrowser();
    }
}
