package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class HelperClass {

    private static WebDriver driver;
    private String url = "https://demoqa.com/";
    private JavascriptExecutor jse;

    public HelperClass() {

    }

    @BeforeTest
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajva\\Downloads\\chromedriver_win32\\chromedriver.exe");
        HelperClass.driver = new ChromeDriver();
        HelperClass.driver.manage().window().maximize();
        driver.get(url);
    }


    public void waiting(WebElement elem) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(elem));
    }

    public WebDriver getDriver() {
        return HelperClass.driver;
    }

    public void passMainPage() {
        //Scroll is needed, because footer blocks button on smaller monitors
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//h5[contains(text(),'Book Store Application')]")).click();
        jse.executeScript("window.scrollBy(0,0)");
    }

    @AfterTest
    public void afterSuite() {
      //  HelperClass.driver.quit();
    }

}
