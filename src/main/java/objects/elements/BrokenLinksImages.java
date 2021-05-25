package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinksImages {

    private WebDriver driver;

    public BrokenLinksImages(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToBrokenLinks() {

        return driver.findElement(By.xpath("//span[contains(text(),'Broken Links - Images')]"));

    }
}
