package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Buttons {

    private WebDriver driver;


    public Buttons(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goButton() {
        return driver.findElement(By.xpath("//span[contains(text(),'Buttons')]"));
    }

    public WebElement doubleClick() {
        return driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
    }

    public WebElement rightClick() {
        return driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
    }

    public WebElement singleClick() {
        return driver.findElement(By.xpath("//button[text()='Click Me']"));
    }
}
