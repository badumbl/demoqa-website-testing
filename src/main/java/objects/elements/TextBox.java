package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBox {

    private WebDriver driver;

    public TextBox(WebDriver driver) {
        this.driver = driver;
    }

    public void fillAndSubmit(String fullName, String email, String address, String permAddress) {
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(fullName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(address);
        driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys(permAddress);
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    public void goToTextBox() {
        driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();
    }
}
