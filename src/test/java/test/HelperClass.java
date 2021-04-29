package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class HelperClass {

    private static WebDriver driver;

    public HelperClass() {
    }

    @BeforeTest
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajva\\Downloads\\chromedriver.exe");
        HelperClass.driver = new ChromeDriver();
        HelperClass.driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return HelperClass.driver;
    }

}
