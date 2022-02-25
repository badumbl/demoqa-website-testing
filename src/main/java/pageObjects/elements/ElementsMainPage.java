package pageObjects.elements;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

@NoArgsConstructor
public class ElementsMainPage extends BasePage {


    @FindBy(xpath = "//div[contains(text(),'Elements')]")
    private WebElement elementsMenuPage;
    @FindBy(xpath = "//span[contains(text(), 'Dynamic Properties')]")
    private WebElement dynamicPropertiesPage;

    public ElementsMainPage(WebDriver driver) {
        super(driver);
        goToElementsMenu();
    }

    public ElementsMainPage goToElementsMenu() {
        waitClickable(elementsMenuPage);
        elementsMenuPage.click();
        js.executeScript("arguments[0].scrollIntoView();", dynamicPropertiesPage);
        waitClickable(dynamicPropertiesPage);
        return this;
    }
}


