package objects.bookStoreApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStoreApp {

    private WebDriver driver;

    public BookStoreApp(WebDriver driver) {
        this.driver = driver;
    }

    public void goToBookStoreApp() {
        driver.findElement(By.xpath("//div[contains(text(),'Book Store Application')]")).click();
    }

    public void existingUser(String username, String password) {
        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='login']")).click();
    }

    public void createNewUser(String firstName, String lastName, String userName, String password) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='newUser']")).click();
        driver.findElement(By.xpath("//input[@id='firstname']]")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastname']]")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='username']]")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='password']]")).sendKeys(password);
        driver.findElement(By.id("recaptcha-anchor")).click();
        driver.findElement(By.xpath("//button[@id='register']")).click();
    }

}
