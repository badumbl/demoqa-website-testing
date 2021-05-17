package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tabs {

    private WebDriver driver;

    public Tabs(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Tabs')]"));
    }

    public WebElement whatB() {
        return driver.findElement(By.xpath("//a[@id='demo-tab-what']"));
    }

    public WebElement whatT() {
        return driver.findElement(By.xpath("//div[@id='demo-tabpane-what']"));
    }

    public WebElement originB() {
        return driver.findElement(By.xpath("//a[@id='demo-tab-origin']"));
    }

    public WebElement originT() {
        return driver.findElement(By.xpath("//div[@id='demo-tabpane-origin']"));
    }

    public WebElement useB() {
        return driver.findElement(By.xpath("//a[@id='demo-tab-use']"));
    }

    public WebElement useT() {
        return driver.findElement(By.xpath("//div[@id='demo-tabpane-use']"));
    }

    public WebElement moreB() {
        return driver.findElement(By.xpath("//a[@id='demo-tab-more']"));
    }
}
