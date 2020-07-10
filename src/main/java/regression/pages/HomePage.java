package regression.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "vrm-input")
    public WebElement carNumberSearchField;

    @FindBy(xpath = "//button[text()='Free Car Check']")
    public WebElement buttonFreeCarCheck;


    public List<HashMap<String, String>> searchForCarDetails(List<String> carNumbersInFile) throws Exception {

        boolean resultsFound = true;
        String value = null;
        List<HashMap<String, String>> myArrList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;

        for(String carNumber:carNumbersInFile){
            map = new HashMap<String, String>();
            carNumberSearchField.sendKeys(carNumber);
            buttonFreeCarCheck.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            if(!driver.findElement(By.tagName("body")).getText().contains("Vehicle Identity")){
             //   Assert.fail("Car number not found");
            }
            else {

                map.put("REGISTRATION",getValueFor("Registration"));
                map.put("MAKE",getValueFor("Make"));
                map.put("MODEL",getValueFor("Model"));
                map.put("COLOR",getValueFor("Colour"));
                map.put("YEAR",getValueFor("Year"));
                myArrList.add(map);

            }
            driver.navigate().back();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return myArrList;
    }

    public String getValueFor(String key) throws Exception {

        if(driver.findElements(By.xpath("//dt[text()='"+key+"']//parent::dl//dd")).size()==0){
            throw new Exception("xpath Locator not found with "+key);
        }
        return driver.findElement(By.xpath("//dt[text()='"+key+"']//parent::dl//dd")).getText();
    }
}
