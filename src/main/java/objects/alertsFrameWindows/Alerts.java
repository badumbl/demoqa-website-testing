package objects.alertsFrameWindows;

import objects.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Alerts extends BasePage {

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


    public Alerts(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public Alerts goAlerts() {
        alertPage.click();
        return this;
    }

    public Alerts alertButton() {
        alertButton.click();
        return this;

    }

    public Alerts alertFiveSec() {
        alertFive.click();
        return this;
    }

    public Alerts alertConfirm() {
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

    public Alerts alertPrompt() {
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

    public Alerts sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
        return this;
    }

    public Alerts acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    public Alerts declineAlert() {
        driver.switchTo().alert().dismiss();
        return this;
    }

    public Alerts waitTillAlert() {
        waitAlertPresent();
        return this;
    }
}
