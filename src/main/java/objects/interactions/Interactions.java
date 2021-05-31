package objects.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Interactions {

    private WebDriver driver;

    public Interactions(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//div[contains(text(), 'Interactions')]"));
    }
}
