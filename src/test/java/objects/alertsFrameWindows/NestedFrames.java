package objects.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFrames {

    private WebDriver driver;

    public NestedFrames(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goTo() {
        WebElement elem = driver.findElement(By.xpath("//span[contains(text(),'Nested Frames')]"));
        elem.click();
        return elem;
    }

    public void parentFrame() {
        driver.switchTo().frame(0);
    }

    public void childFrame() {
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);

    }

    public void mainFrame() {
        driver.switchTo().parentFrame();
    }
}
