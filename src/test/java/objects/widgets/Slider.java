package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Slider {

    WebDriver driver;

    public Slider(WebDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.findElement(By.xpath("//span[contains(text(),'Slider')]")).click();
    }

    public void moveTo() {
        WebElement elem = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
        new Actions(driver).dragAndDropBy(elem, 50, 0).perform();
    }
}
