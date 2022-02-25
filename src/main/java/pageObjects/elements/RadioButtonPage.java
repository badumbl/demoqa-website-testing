package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends ElementsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Radio Button')]")
    private WebElement radioButtonPage;
    @FindBy(xpath = "//label[contains(text(),'Yes')]")
    private WebElement yesButton;
    @FindBy(xpath = "//label[contains(text(),'Impressive')]")
    private WebElement impressiveButton;
    @FindBy(xpath = "//label[contains(text(),'No')]")
    private WebElement noButton;
    @FindBy(xpath = "//span[@class='text-success']")
    private WebElement successText;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public RadioButtonPage goToRadio() {
        waitClickable(radioButtonPage);
        radioButtonPage.click();
        waitingElementOnPage(noButton);
        return this;
    }

    public RadioButtonPage checkYes() {
        yesButton.click();
        return this;
    }

    public RadioButtonPage checkImpr() {
        waitClickable(impressiveButton);
        impressiveButton.click();
        waitVisibility(successText);
        return this;
    }

    public RadioButtonPage checkNo() {
        waitClickable(impressiveButton);
        noButton.click();
        return this;
    }

    public boolean isTextEquals(String text){
        return successText.getText().equals(text);
    }
}
