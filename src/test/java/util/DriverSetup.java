package util;
/**
 * This class is created to define webdriver setup for the automation of application
 * Bugs: NA
 *
 * @author Somesh Kumud
 * @version 1.0
 * @since 21/02/2021
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static util.BaseUtil.defaultProperties;

public class DriverSetup {
    public static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    public static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";

    public static WebDriver driver;

    /**
     * createDriver method will create webdriver object on the basis of browser name passed from frature file
     */
    public static void createDriver() {
        switch (defaultProperties.get("browser").toUpperCase()) {
            case "CHROME":
                System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;

//            case "IE":
//                System.setProperty(IE_DRIVER_PROPERTY,System.getProperty("user.dir") +"\\drivers\\iedriver.exe");
//                driver = new InternetExplorerDriver();
//                break;

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(defaultProperties.get("implicitWait")), TimeUnit.SECONDS);
    }

    /**
     * closeDriver method will quite webdriver object
     */
    public static void closeDriver() {
        try {
            driver.quit();
        } catch (RuntimeException ex) {
            throw new RuntimeException("Fail to close driver : " + ex.getMessage());
        }
    }
}
