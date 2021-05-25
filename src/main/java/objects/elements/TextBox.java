package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox {

    private WebDriver driver;

    public TextBox(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToTextBox() {
        return driver.findElement(By.xpath("//span[contains(text(),'Text Box')]"));
    }

    public WebElement name() {
        return driver.findElement(By.xpath("//input[@id='userName']"));
    }

    public WebElement email() {
        return driver.findElement(By.xpath("//input[@id='userEmail']"));
    }

    public WebElement address() {
        return driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
    }

    public WebElement permAddress() {
        return driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
    }

    public WebElement submitButton() {
        return driver.findElement(By.xpath("//button[@id='submit']"));
    }


}
