package steps;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.AccountSummaryPage;
import pages.HomePage;
import pages.RegistrationPage;
import util.BaseUtil;

import java.util.List;

import static util.DriverSetup.createDriver;
import static util.DriverSetup.driver;

/**
 * Author :  Somesh Kumud
 */
public class QATaskSteps extends BaseUtil {

    /**
     * @Before hook will execute before scenario and  load default properties file into hashmap
     */
    @Before
    public void InitializeTest() {
        loadDefaultProperties();
    }

    /**
     * @After hook will execute after execution of scenario and  -
     * 1. will print failed scenarios name on console
     * 2. Close browser after scenario
     */
    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("SCENARIO FAILED : " + scenario.getName());
            try {
                final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("SCENARIO PASSED : " + scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
//        closeDriver();
    }

    @Given("^Launch browser and navigate to Farnell$")
    public void launchBrowserAndNavigateToFarnell() {
        createDriver();
        driver.get(defaultProperties.get("url"));
    }

    @And("^Navigate to registration page$")
    public void navigateToRegistrationPage() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegistration();
    }


    @And("^Set \"([^\"]*)\" as \"([^\"]*)\"$")
    public void setAs(String propertyName, String propertyValue) throws Throwable {
        if (!propertyValue.equalsIgnoreCase("")){
            defaultProperties.put(propertyName,propertyValue);
        }
    }

    @And("^Register user$")
    public void registerUser() {
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.registerUser();
    }

    @Then("^Login name displayed as \"([^\"]*)\"$")
    public void loginNameDisplayedAs(String arg0) throws Throwable {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);
        System.out.println(accountSummaryPage.getLoginGretting());
    }

}
