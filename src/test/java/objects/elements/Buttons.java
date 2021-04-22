package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Buttons {

    private WebDriver driver;
    private Actions actions;

    public Buttons(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void goButton() {
        driver.findElement(By.xpath("//span[contains(text(),'Buttons')]")).click();
    }

    public void doubleClick() {
        WebElement button = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        actions.doubleClick(button).perform();
    }

    public void rightClick() {
        WebElement button = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        actions.contextClick(button).perform();
    }

    public void singleClick() {
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();
    }
}
