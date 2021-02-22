package pages;
/**
 * This class is created to define page objects of Consent page in Farnell application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 21/02/2021
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.BaseUtil;


public class RegistrationPage extends BaseUtil {

    /**
     * Page factory constructor function will instantiate objects
     *
     * @param driver
     */
    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.manage().deleteAllCookies();
    }

    @FindBy(how = How.ID, using = "logonId")
    private WebElement textUsername;

    @FindBy(how = How.ID, using = "logonPassword")
    private WebElement textPassword;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement textFullName;

    @FindBy(how = How.ID, using = "email1")
    private WebElement textEmail;

    @FindBy(how = How.XPATH, using = "//label[@for='rememberMe']/span")
    private WebElement checkboxRememberMe;

    @FindBy(how = How.ID, using = "registerValidate")
    private WebElement buttonRegister;

    @FindBy(how = How.ID, using = "emailCheckBox")
    private WebElement checkboxReceiveEmail;


    /**
     * registerUser method will -
     * 1. Register user on Farnell
     */
    public void registerUser() {
        enterValueInTextBox(textUsername, defaultProperties.get("username"));
        enterValueInTextBox(textPassword, defaultProperties.get("password"));
        enterValueInTextBox(textFullName, defaultProperties.get("fullName"));
        enterValueInTextBox(textEmail, defaultProperties.get("email"));
        clickOnCheckbox(checkboxRememberMe, defaultProperties.get("rememberMe"));

        clickOn(buttonRegister);
        Wait(90);
    }


}
