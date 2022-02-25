package pageObjects.alertsFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class BrowserWindowsPage extends AlertsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    private WebElement browserWindowPage;
    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement newTabButton;
    @FindBy(xpath = "//button[@id='windowButton']")
    private WebElement newWindowButton;
    @FindBy(xpath = "//button[@id='messageWindowButton']")
    private WebElement messageWindowButton;
    private ArrayList<String> tabs;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public BrowserWindowsPage go() {
        waitClickable(browserWindowPage);
        browserWindowPage.click();
        js.executeScript("arguments[0].scrollIntoView();", newTabButton);
        return this;
    }

    public BrowserWindowsPage newTab() {
        newWindowButton.click();
        return this;
    }

    public BrowserWindowsPage newWindow() {
        newWindowButton.click();
        return this;
    }

    public BrowserWindowsPage newWindowMessage() {
        messageWindowButton.click();
        return this;
    }

    public boolean isUrlCorrect(String urlToCheck) {
        try {
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            String check = driver.getCurrentUrl();
            driver.close();
            return check.equals(urlToCheck);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } finally {
            //driver.close();
            driver.switchTo().window(tabs.get(0));
        }
    }
}
