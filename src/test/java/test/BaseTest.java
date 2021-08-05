package test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;


public class BaseTest {

    protected WebDriverFactory wbf;
    protected WebDriver driver;
    protected JavascriptExecutor jse;
    protected final static String BASE_URL = "https://demoqa.com/";
    private static RequestSpecification httpRequest;

    /*@BeforeTest
    public void init() {
        wbf = new WebDriverFactory();
        driver = wbf.getDriver();
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();
    }*/

    public BaseTest() {
        wbf = new WebDriverFactory();
        driver = wbf.getDriver();
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();
    }

    public void passMainPage() {
        //Scroll is needed, because footer blocks button on smaller monitors
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//h5[contains(text(),'Book Store Application')]")).click();
        jse.executeScript("window.scrollBy(0,0)");
    }

    protected int getStatusCode(String endPoint) {
        return httpRequest.get(endPoint).getStatusCode();
    }


  /*  @AfterClass
    public void afterSuite() {
        driver.quit();
    }*/

}
