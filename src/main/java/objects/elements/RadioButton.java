package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton {

    private WebDriver driver;

    public RadioButton(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToRadio() {
       return driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]"));
    }

    public WebElement checkYes() {
        return driver.findElement(By.xpath("//label[contains(text(),'Yes')]"));
    }

    public WebElement checkImpr() {
        return driver.findElement(By.xpath("//label[contains(text(),'Impressive')]"));
    }

    public WebElement checkNo() {
        return  driver.findElement(By.xpath("//label[contains(text(),'No')]"));
    }
}
