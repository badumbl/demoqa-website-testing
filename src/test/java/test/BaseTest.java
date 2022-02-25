package test;


import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {

    protected WebDriverFactory driverFactory;
    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected final static String BASE_URL = "https://demoqa.com/";
    private static RequestSpecification httpRequest;
    protected WebDriverWait wait;

    public BaseTest() {
    }

    @BeforeClass
    public void beforeClass() {
        driverFactory = new WebDriverFactory();
        driver = driverFactory.getDriver();
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();
        wait = new WebDriverWait(driver, 10);
        passMainPage();
    }


    public void passMainPage() {
        //Scroll is needed, because footer blocks button on smaller monitors
        driver.get(BASE_URL);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//h5[contains(text(),'Book Store Application')]")).click();
        jse.executeScript("window.scrollBy(0,0)");
        // wait.until(driver -> driver.findElement(By.xpath("//div[contains(text(),'Book Store Application')]")).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Book Store Application')]"))));
    }

    protected int getStatusCode(String endPoint) {
        return httpRequest.get(endPoint).getStatusCode();
    }

    @AfterClass(alwaysRun = true)
    public void afterSuite() {
        driver.quit();
    }

}
