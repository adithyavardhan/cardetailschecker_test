package regression;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import regression.pages.HomePage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MyStepdefs {

    FileUtilsClass fileUtilsClass = new FileUtilsClass();
    List<String> linesInFile;
    List<String> carNumbersInFile;
    List<HashMap<String, String>> expectedCarNumbersDetails;
    List<HashMap<String, String>> actualCarNumbersDetails;
    HomePage homePage;


    @Given("^a file exists with name \"([^\"]*)\"$")
    public void     inInputFileExistsWithName(String filename) throws Throwable {
        Assert.assertTrue("Checking File Exists", fileUtilsClass.checkFileExists(filename));
    }

    @When("^the data is read from the file and saved as input data$")
    public void theDataIsReadFromTheFileAndSavedAsInputData() throws IOException {
        linesInFile = fileUtilsClass.readFileLines();
        carNumbersInFile = fileUtilsClass.abstractCarNumbers(linesInFile);

    }

    @When("^fill the car numbers and read the data$")
    public void fill_the_car_numbers_and_read_the_data() throws Throwable {
        homePage  = new HomePage(DriverManager.driver);
        actualCarNumbersDetails = homePage.searchForCarDetails(carNumbersInFile);
        System.out.println(actualCarNumbersDetails);

    }

    @And("^open the \"([^\"]*)\" site$")
    public void openTheSite(String url) throws Throwable {
        DriverManager.driver.get(url);
    }

    @When("^the data is read from the file and saved as expected data$")
    public void theDataIsReadFromTheFileAndSavedAsExpectedData() throws IOException {
        linesInFile = fileUtilsClass.readFileLines();
        expectedCarNumbersDetails = fileUtilsClass.abstractExpDetailsOfCars(linesInFile);

        System.out.println(expectedCarNumbersDetails);

    }


    @Then("^the compare the car details with output data$")
    public void theCompareTheCarDetailsWithOutputData() {
        int i=0;
        for(HashMap<String,String> map:expectedCarNumbersDetails){

            for(HashMap<String,String> map1:actualCarNumbersDetails){
                if(map.get("REGISTRATION").equals(map1.get("REGISTRATION"))){
                    if(!map.equals(map1))
                    {
                        Assert.assertEquals(map,map1);
                    }
                }
            }
            i++;
        }

//        Assert.assertEquals(carNumbersInFile.size(),actualCarNumbersDetails.size());
    }
}
