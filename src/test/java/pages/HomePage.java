package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil;


/**
 * This class is created to define page objects of Homepage page in Farnell application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 21/02/2021
 */

public class HomePage extends BaseUtil {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.manage().deleteAllCookies();
    }

    @FindBy(how = How.XPATH, using = "//a[@class='regLink omTagEvt']")
    private WebElement linkRegister;


    /**
     * navigateToRegistration method will -
     * Click on Register link and navigate to registration page
     */
    public void navigateToRegistration() {
        clickOn(linkRegister);

    }

}
