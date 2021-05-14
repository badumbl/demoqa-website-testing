package objects.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModalDialogs {

    private WebDriver driver;

    public ModalDialogs(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Modal Dialogs')]"));
    }

    public void small() {
        driver.findElement(By.xpath("//button[@id='showSmallModal']")).click();
    }

    public void large() {
        driver.findElement(By.xpath("//button[@id='showLargeModal']")).click();
    }

    public void close(String size) {
        if (size.equals("small")) {
            driver.findElement(By.xpath("//button[@id='closeSmallModal']")).click();
        } else {
            driver.findElement(By.xpath("//button[@id='closeLargeModal']")).click();
        }
    }
}
