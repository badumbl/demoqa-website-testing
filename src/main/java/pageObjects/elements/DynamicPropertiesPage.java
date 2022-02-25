package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicPropertiesPage extends ElementsMainPage {

    @FindBy(xpath = "//span[contains(text(), 'Dynamic Properties')]")
    private WebElement dynamicPropPage;
    @FindBy(xpath = "//button[@id='enableAfter']")
    private WebElement fiveSecButton;
    @FindBy(xpath = "//button[@id='colorChange']")
    private WebElement colorButton;
    @FindBy(xpath = "//button[@id='visibleAfter']")
    private WebElement invisibleButton;


    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    public DynamicPropertiesPage goToDp() {
        waitVisibility(dynamicPropPage);
        dynamicPropPage.click();
        waitingElementOnPage(fiveSecButton);
       return this;
    }

    public WebElement fiveSecondButton() {
        super.waitAndClick(fiveSecButton);
        return fiveSecButton;
    }

    public WebElement colorButton() {
        return colorButton;
    }

    public WebElement invisibleButton() {
        super.waitVisibility(invisibleButton);
        return invisibleButton;
    }


}
