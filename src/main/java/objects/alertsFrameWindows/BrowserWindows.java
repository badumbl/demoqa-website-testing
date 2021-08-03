package objects.alertsFrameWindows;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class BrowserWindows extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    private WebElement browserWindowPage;
    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement newTabButton;
    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement newWindowButton;
    @FindBy(xpath = "//button[@id='messageWindowButton']")
    private WebElement messageWindowButton;
    private ArrayList<String> tabs;

    public BrowserWindows(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public BrowserWindows go() {
        browserWindowPage.click();
        return this;
    }

    public BrowserWindows newTab() {
        newWindowButton.click();
        return this;
    }

    public BrowserWindows newWindow() {
        newWindowButton.click();
        return this;
    }

    public BrowserWindows newWindowMessage() {
        messageWindowButton.click();
        return this;
    }

    public boolean isUrlCorrect(String urlToCheck) {
        try {
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            return driver.getCurrentUrl().equals(urlToCheck);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } finally {
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
    }
}
