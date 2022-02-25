package pageObjects.alertsFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class AlertsMainPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Alerts, Frame & Windows')]")
    private WebElement alFrWi;
    @FindBy(xpath = "//span[contains(text(),'Modal Dialogs')]")
    private WebElement modalPage;

    public AlertsMainPage(WebDriver driver) {
        super(driver);
        goToAlerts();
    }

    public AlertsMainPage goToAlerts() {
        waitClickable(alFrWi);
        alFrWi.click();
        js.executeScript("arguments[0].scrollIntoView();", modalPage);
        waitClickable(modalPage);
        return this;
    }
}
