package pages;

/**
 * This class is created to define page objects of Login page in Farnell application
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

public class AccountSummaryPage extends BaseUtil {
    /**
     * Page factory constructor function will instantiate objects
     * @param driver
     */

    public AccountSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.ID, using = "loggedInPar")
    private WebElement labelLoginName;

    /**
     * getLoginGretting method will be called afterlogin to Farnell application and it will-
     * 1. return login gretting
     */

    public String  getLoginGretting() {
        return labelLoginName.getText();
    }
}
