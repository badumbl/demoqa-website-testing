package objects.elements;

import objects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Buttons extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Buttons')]")
    private WebElement buttonsPage;
    @FindBy(xpath = "//button[@id='doubleClickBtn']")
    private WebElement doubleClickButton;
    @FindBy(xpath = "//button[@id='rightClickBtn']")
    private WebElement rightClickButton;
    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement singleClickButton;
    @FindBy(xpath = "//p[@id='doubleClickMessage']")
    private WebElement doubleClickButtonMessage;
    @FindBy(xpath = "//p[@id='rightClickMessage']")
    private WebElement rightClickButtonMessage;
    @FindBy(xpath = "//p[@id='dynamicClickMessage']")
    private WebElement singleClickButtonMessage;

    public Buttons(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public Buttons goButton() {
        buttonsPage.click();
        waitVisibility(doubleClickButton);
        driver.findElement(By.cssSelector(".pattern-backgound")).click();
        return this;
    }

    public Buttons doubleClick() {
        action.doubleClick(doubleClickButton).perform();
        return this;
    }

    public Buttons rightClick() {
        action.contextClick(rightClickButton).perform();
        return this;
    }

    public Buttons singleClick() {
        singleClickButton.click();
        return this;
    }

    public String getDoubleClickText() {
        return doubleClickButtonMessage.getText();
    }

    public String getRightClickText() {
        return rightClickButtonMessage.getText();
    }

    public String getSingleClickText() {
        return singleClickButtonMessage.getText();
    }

}
