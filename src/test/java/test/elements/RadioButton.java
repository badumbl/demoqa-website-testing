package test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {

    private WebDriver driver;

    public RadioButton(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRadio() {
        driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]")).click();
    }

    public void checkYes() {
        driver.findElement(By.xpath("//label[contains(text(),'Yes')]")).click();
    }

    public void checkImpr() {
        driver.findElement(By.xpath("//label[contains(text(),'Impressive')]")).click();
    }

    public void checkNo() {
        driver.findElement(By.xpath("//label[contains(text(),'No')]")).click();
    }
}
