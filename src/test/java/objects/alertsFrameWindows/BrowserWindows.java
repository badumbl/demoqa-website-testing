package objects.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindows {

    private WebDriver driver;

    public BrowserWindows(WebDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]")).click();
    }

    public void newTab() {
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
    }

    public void newWindow() {
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();
    }

    public void newWindowMessage() {
        driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
    }
}
