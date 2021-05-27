package objects.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserWindows {

    private WebDriver driver;

    public BrowserWindows(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
       return driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]"));
    }

    public WebElement newTab() {
        return driver.findElement(By.xpath("//button[@id='tabButton']"));
    }

    public WebElement newWindow() {
        return driver.findElement(By.xpath("//button[@id='windowButton']"));
    }

    public WebElement newWindowMessage() {
        return driver.findElement(By.xpath("//button[@id='messageWindowButton']"));
    }
}
