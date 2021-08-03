package objects.widgets;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Widgets extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Widgets')]")
    private WebElement widgetsPage;
    @FindBy(xpath = "//span[contains(text(),'Select Menu')]")
    private WebElement selectMenuPage;

    public Widgets(WebDriver driver) {
        super(driver);
    }

    public Widgets go() {
        widgetsPage.click();
        waitVisibility(selectMenuPage);
        return this;
    }
}
