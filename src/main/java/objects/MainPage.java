package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    public void init(String testLink) {
        driver.get(testLink);
    }

    public void goToElement(String elem) {
        //Scroll is needed, because footer blocks button on smaller monitors
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//h5[contains(text(),'" + elem + "')]")).click();

    }

}
