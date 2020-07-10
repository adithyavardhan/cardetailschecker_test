package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;

    public DriverManager()
    {
        PageFactory.initElements(driver,this);
    }

    public void openBrowser(String browser) {
        switch (browser) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }

            case "edge": {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            }

            default: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
        }
    }

    public void navigateTo(String url)
    {
        driver.get(url);
    }
    public void maxBrowser() {
        driver.manage().window().maximize();
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

}
