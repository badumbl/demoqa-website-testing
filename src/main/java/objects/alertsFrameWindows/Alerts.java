package objects.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Alerts {

    private WebDriver driver;

    public Alerts(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goAlerts() {
        return driver.findElement(By.xpath("//span[contains(text(),'Alerts')]"));
    }

    public WebElement alert() {
        return driver.findElement(By.xpath("//button[@id='alertButton']"));
    }

    public WebElement alertFive() {
        return driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
    }

    public WebElement alertConfirm() {
        return  driver.findElement(By.xpath("//button[@id='confirmButton']"));
    }

    public WebElement alertPrompt() {
        return driver.findElement(By.xpath("//button[@id='promtButton']"));
    }


}
