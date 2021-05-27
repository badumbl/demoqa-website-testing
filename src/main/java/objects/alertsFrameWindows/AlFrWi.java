package objects.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlFrWi {

    private WebDriver driver;

    public AlFrWi(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
       return driver.findElement(By.xpath("//div[contains(text(),'Alerts, Frame & Windows')]"));
    }
}
