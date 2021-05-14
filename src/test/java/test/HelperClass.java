package test;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class HelperClass {

    private static WebDriver driver;

    public HelperClass() {
    }

    @BeforeTest
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajva\\Downloads\\chromedriver_win32\\chromedriver.exe");
        HelperClass.driver = new ChromeDriver();
        HelperClass.driver.manage().window().maximize();
    }


    public void waiting(WebElement elem) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(elem));
    }

    public WebDriver getDriver() {
        return HelperClass.driver;
    }

    @AfterTest
    public void afterSuite() {
        HelperClass.driver.quit();
    }

}
