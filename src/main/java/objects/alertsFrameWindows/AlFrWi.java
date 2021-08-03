package objects.alertsFrameWindows;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlFrWi extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Alerts, Frame & Windows')]")
    private WebElement alFrWi;
    @FindBy(xpath = "//span[contains(text(),'Alerts')]")
    private WebElement alertPage;

    public AlFrWi(WebDriver driver) {
        super(driver);
    }

    public AlFrWi go() {
        waitVisibility(alFrWi);
        alFrWi.click();
        waitVisibility(alertPage);
        return this;
    }
}
