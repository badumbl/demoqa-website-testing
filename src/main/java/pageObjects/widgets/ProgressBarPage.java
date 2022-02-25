package pageObjects.widgets;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class ProgressBarPage extends WidgetsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Progress Bar')]")
    private WebElement progressBarPage;
    @FindBy(xpath = "//button[@id='startStopButton']")
    private WebElement startStopButton;
    @FindBy(xpath = "//button[@id='resetButton']")
    private WebElement resetButton;
    @FindBy(xpath = "//div[@class='progress-bar bg-success']")
    private WebElement success;
    @FindBy(xpath = "//div[@class='progress-bar bg-info']")
    private WebElement inProgress;
    @FindBy(xpath = "//div[@id='progressBar']")
    private WebElement progressBar;


    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public ProgressBarPage go() {
        waitVisibility(progressBarPage);
        progressBarPage.click();
        waitingElementOnPage(progressBar);
        return this;
    }

    public ProgressBarPage startStopButtonClick() {
        startStopButton.click();
        return this;
    }

    public ProgressBarPage resetButtonClick() {
        resetButton.click();
        return this;
    }

    public ProgressBarPage waitingExactNumber(String value) {
        super.waitingText(inProgress, value);
        startStopButtonClick();
        return this;
    }

    public ProgressBarPage waitngResetButton(WebElement elem) {
        super.waitVisibility(elem);
        return this;
    }

}
