package objects.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Resizable {

    private WebDriver driver;

    public Resizable(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Resizable')]"));
    }

    public WebElement resizeInside() {
        return driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']//child::span"));
    }

    public WebElement resizeOutside() {
        return driver.findElement(By.xpath("//div[@id='resizable']//child::span"));
    }
}
