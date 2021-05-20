package objects.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlFrWi {

    private WebDriver driver;

    public AlFrWi(WebDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.findElement(By.xpath("//div[contains(text(),'Alerts, Frame & Windows')]")).click();
    }
}
