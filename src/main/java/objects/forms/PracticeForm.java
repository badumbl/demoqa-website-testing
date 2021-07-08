package objects.forms;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PracticeForm {

    private WebDriver driver;
    private Actions act;
    private String visible = "//div[@class='subjects-auto-complete__option subjects-auto-complete__option--is-focused css-1n7v3ny-option']";

    public PracticeForm(WebDriver driver) {
        this.driver = driver;
        act = new Actions(driver);
    }

    public WebElement goToForm() {
        return driver.findElement(By.xpath("//div[contains(text(),'Forms')]"));

    }

    public WebElement goToPractice() {
        return driver.findElement(By.xpath("//span[contains(text(),'Practice Form')]"));
    }


    public void fillForm(String fName, String lName, String email, String gender, String mobile,
                         String dayBirth, String monthBirth, int yearBirth, ArrayList<String> subjects,
                         String hobbies, String address, String state, String city) throws InterruptedException {

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//label[contains(text(),'" + gender + "')]")).click();
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(mobile);
        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'" + monthBirth + "')]")).click();
        driver.findElement(By.xpath("//option[contains(text(),'" + yearBirth + "')]")).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--" + dayBirth + "']"))
                .click();
        driver.findElement(By
                .xpath("//div[@class='subjects-auto-complete__input']"))
                .click();
        for (String subject : subjects) {
            act.sendKeys(subject).build().perform();
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(10, TimeUnit.SECONDS)
                    .pollingEvery(1, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class);
            wait.until((WebDriver) -> driver.findElement(By.xpath(visible)).isDisplayed());
            driver.findElement(By.xpath(visible)).click();
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//label[contains(text(),'" + hobbies + "')]")).click();
        driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(address);
        driver.findElement(By.xpath("//div[contains(text(),'Select State')]")).click();
        driver.findElement(By.xpath("//div[text()='" + state + "']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Select City')]")).click();
        driver.findElement(By.xpath("//div[text()='" + city + "']")).click();
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }
}
