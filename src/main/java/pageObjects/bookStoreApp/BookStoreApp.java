package pageObjects.bookStoreApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStoreApp {

    private WebDriver driver;

    public BookStoreApp(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToBookStoreApp() {
        return driver.findElement(By.xpath("//div[contains(text(),'Book Store Application')]"));
    }

    public WebElement goToLogin() {
        return driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
    }

    public void existingUser(String username, String password) {
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login']")).click();
    }

    public void createNewUser(String firstName, String lastName, String userName, String password) {
        driver.findElement(By.xpath("//button[@id='newUser']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//div[@id='g-recaptcha']")).click();
    }

}
