package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicProperties {
    private WebDriver driver;
    private WebElement elem;

    public DynamicProperties(WebDriver driver) {
        this.driver = driver;
    }

    public void goToDp() {
        driver.findElement(By.xpath("//span[contains(text(), 'Dynamic Properties')]")).click();
    }

    public WebElement checkFiveSec() {
        elem = driver.findElement(By.xpath("//button[@id='enableAfter']"));
        return elem;
    }

    public WebElement checkColor() {
        elem = driver.findElement(By.xpath("//button[@id='colorChange']"));
        return elem;
    }

    public WebElement checkInvis() {
        elem = driver.findElement(By.xpath("//button[@id='visibleAfter']"));
        return elem;
    }


}
