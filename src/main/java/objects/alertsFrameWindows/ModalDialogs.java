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

    public WebElement small() {
        return driver.findElement(By.xpath("//button[@id='showSmallModal']"));
    }

    public WebElement large() {
        return driver.findElement(By.xpath("//button[@id='showLargeModal']"));
    }

    public WebElement close(String size) {
        if (size.equals("small")) {
           return driver.findElement(By.xpath("//button[@id='closeSmallModal']"));
        } else {
           return driver.findElement(By.xpath("//button[@id='closeLargeModal']"));
        }
    }
}
