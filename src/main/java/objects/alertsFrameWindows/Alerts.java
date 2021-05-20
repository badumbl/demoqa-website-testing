package objects.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alerts {

    private WebDriver driver;

    public Alerts(WebDriver driver) {
        this.driver = driver;
    }

    public void goAlerts() {
        driver.findElement(By.xpath("//span[contains(text(),'Alerts')]")).click();
    }

    public void alert() {
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
    }

    public void alertFive() {
        driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
    }

    public void alertConfirm() {
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
    }

    public void alertPrompt() {
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void declineAlert() {
        driver.switchTo().alert().dismiss();
    }
}
