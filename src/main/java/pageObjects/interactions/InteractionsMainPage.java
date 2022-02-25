package pageObjects.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;


public class InteractionsMainPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Interactions')]")
    private WebElement interactionsPage;
    @FindBy(xpath = "//span[contains(text(),'Dragabble')]")
    private WebElement draggablePage;

    public InteractionsMainPage(WebDriver driver) {
        super(driver);
        goToInteractions();
    }

    public InteractionsMainPage goToInteractions() {
        waitClickable(interactionsPage);
        interactionsPage.click();
        waitingElementOnPage(draggablePage);
        return this;
    }
}
