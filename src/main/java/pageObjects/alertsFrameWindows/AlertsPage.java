package pageObjects.alertsFrameWindows;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends AlertsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    private WebElement alertPage;
    @FindBy(xpath = "//button[@id='alertButton']")
    private WebElement alertButton;
    @FindBy(xpath = "//button[@id='timerAlertButton']")
    private WebElement alertFive;
    @FindBy(xpath = "//button[@id='confirmButton']")
    private WebElement alertConfirm;
    @FindBy(xpath = "//span[@id='confirmResult']")
    private WebElement confirmResult;
    @FindBy(xpath = "//span[@id='promptResult']")
    private WebElement promptResult;
    @FindBy(xpath = "//button[@id='promtButton']")
    private WebElement alertPrompt;


    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage goAlerts() {
        waitVisibility(alertPage);
        alertPage.click();
        js.executeScript("arguments[0].scrollIntoView();", alertButton);
        return this;
    }

    public AlertsPage alertButton() {
        alertButton.click();
        return this;

    }

    public AlertsPage alertFiveSec() {
        alertFive.click();
        return this;
    }

    public AlertsPage alertConfirm() {
        alertConfirm.click();
        return this;
    }

    public boolean isAlertConfirmResultRight(String text) {
        try {
            return confirmResult.getText().equals(text);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public AlertsPage alertPrompt() {
        alertPrompt.click();
        return this;
    }

    public boolean isAlertPromptResultRight(String text) {
        try {
            return promptResult.getText().equals(text);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAlertTextRight(String text) {
        try {
            return driver.switchTo().alert().getText().equals(text);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public AlertsPage sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public AlertsPage acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public AlertsPage declineAlert() {
        driver.switchTo().alert().dismiss();
        return this;
    }

    public AlertsPage waitTillAlert() {
        waitAlertPresent();
        return this;
    }
}
