package objects.widgets;

import lombok.Data;
import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ProgressBar extends BasePage {

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

    public ProgressBar(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public ProgressBar go() {
        progressBarPage.click();
        return this;
    }

    public ProgressBar startStopButtonClick() {
        startStopButton.click();
        return this;
    }

    public ProgressBar resetButtonClick() {
        resetButton.click();
        return this;
    }

    public ProgressBar waitingExactNumber(String value) {
        super.waitingText(inProgress, value);
        startStopButtonClick();
        return this;
    }

    public ProgressBar waitngResetButton(WebElement elem) {
        super.waitVisibility(elem);
        return this;
    }

}
