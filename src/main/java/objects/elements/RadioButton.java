package objects.elements;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButton extends BasePage {

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

    public RadioButton(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public RadioButton goToRadio() {
        radioButtonPage.click();
        return this;
    }

    public RadioButton checkYes() {
        yesButton.click();
        return this;
    }

    public RadioButton checkImpr() {
        impressiveButton.click();
        return this;
    }

    public RadioButton checkNo() {
        noButton.click();
        return this;
    }

    public boolean isTextEquals(String text){
        return successText.getText().equals(text);
    }
}
