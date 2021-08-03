package objects.elements;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsMenu extends BasePage {


    @FindBy(xpath = "//div[contains(text(),'Elements')]")
    private WebElement elementsMenuPage;
    @FindBy(xpath = "//span[contains(text(), 'Dynamic Properties')]")
    private WebElement dynamicPropertiesPage;

    public ElementsMenu(WebDriver driver) {
        super(driver);
    }

    public ElementsMenu goToElementsMenu() {
        waitVisibility(elementsMenuPage);
        elementsMenuPage.click();
        waitVisibility(dynamicPropertiesPage);
        return this;
    }
}


