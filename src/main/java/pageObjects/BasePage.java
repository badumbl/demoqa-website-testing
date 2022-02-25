package pageObjects;

import lombok.NoArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class BasePage {

    protected static final String BASE_URL = "https://demoqa.com/";
    private static final long DEFAULT_TIMEOUT_SECONDS = 15;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Actions action;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS);
        this.wait.pollingEvery(1, TimeUnit.MILLISECONDS);
        this.js = (JavascriptExecutor) driver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected void waitAndClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected WebElement waitVisibility(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected WebElement waitClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitAlertPresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void waitingExists(File f) {
        wait.until((WebDriver wd) -> f.exists());

    }

    protected void waitingClassValue(WebElement element, String value) {
        wait.until((WebDriver wd) -> element.getAttribute("class").equals(value));
    }

    protected void waitingText(WebElement element, String value) {
        wait.until((WebDriver wb) -> element.getText().equals(value));
    }

    protected void waitingElementOnPage(WebElement element) {
        js.executeScript("window.scrollBy(0,0)");
        waitVisibility(element);
    }

    protected void scrollIntoViewAndClick(WebElement element) {
        waitVisibility(element);
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

}
