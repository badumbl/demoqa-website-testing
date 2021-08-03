package objects.elements;

import objects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicProperties extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Dynamic Properties')]")
    private WebElement dynamicPropPage;
    @FindBy(xpath = "//button[@id='enableAfter']")
    private WebElement fiveSecButton;
    @FindBy(xpath = "//button[@id='colorChange']")
    private WebElement colorButton;
    @FindBy(xpath = "//button[@id='visibleAfter']")
    private WebElement invisibleButton;


    public DynamicProperties(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public DynamicProperties goToDp() {
        dynamicPropPage.click();
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
