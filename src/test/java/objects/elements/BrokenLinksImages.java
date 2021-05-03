package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BrokenLinksImages {

    private WebDriver driver;

    public BrokenLinksImages(WebDriver driver) {
        this.driver = driver;
    }

    public void goToBrokenLinks() {
        //Scroll is needed, because footer blocks button on smaller monitors
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//span[contains(text(),'Broken Links - Images')]")).click();

    }
}
