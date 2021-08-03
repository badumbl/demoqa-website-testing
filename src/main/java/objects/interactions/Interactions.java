package objects.interactions;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Interactions extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Interactions')]")
    private WebElement interactionsPage;
    @FindBy(xpath = "//span[contains(text(),'Droppable')]")
    private WebElement droppablePage;

    public Interactions(WebDriver driver) {
        super(driver);
    }

    public Interactions go() {
        interactionsPage.click();
        waitVisibility(droppablePage);
        return this;
    }
}
