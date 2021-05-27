package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProgressBar {

    private WebDriver driver;

    public ProgressBar(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Progress Bar')]"));
    }

    public WebElement startStopButton() {
        return driver.findElement(By.xpath("//button[@id='startStopButton']"));
    }

    public WebElement resetButton() {
        return driver.findElement(By.xpath("//button[@id='resetButton']"));
    }

}
