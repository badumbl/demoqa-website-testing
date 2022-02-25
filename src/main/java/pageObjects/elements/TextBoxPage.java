package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends ElementsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Text Box')]")
    private WebElement textBoxPage;
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement nameField;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailField;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement addressField;
    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement permAddressField;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//p[@id='name']")
    private WebElement nameTextOutput;
    @FindBy(xpath = "//p[@id='email']")
    private WebElement emailTextOutput;
    @FindBy(xpath = "//p[@id='currentAddress']")
    private WebElement addressTextOutput;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    private WebElement permAddressTextOutput;

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage goToTextBox() {
        waitVisibility(textBoxPage);
        textBoxPage.click();
        waitingElementOnPage(nameField);
        return this;
    }

    public WebElement getNameTextOutput() {
        return nameTextOutput;
    }

    public WebElement getEmailTextOutput() {
        return emailTextOutput;
    }

    public WebElement getAddressTextOutput() {
        return addressTextOutput;
    }

    public WebElement getPermAddressTextOutput() {
        return permAddressTextOutput;
    }

    public TextBoxPage submitForm(String name, String email, String currentAddress, String permanent) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        addressField.sendKeys(currentAddress);
        permAddressField.sendKeys(permanent);
        submitButton.click();
        return this;
    }
}
