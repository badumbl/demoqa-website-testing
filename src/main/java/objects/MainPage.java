package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToElement(String elem) {
        return driver.findElement(By.xpath("//h5[contains(text(),'" + elem + "')]"));
    }
}
