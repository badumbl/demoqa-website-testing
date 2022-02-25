package pageObjects.widgets;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

@NoArgsConstructor
public class WidgetsMainPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Widgets')]")
    private WebElement widgetsPage;
    @FindBy(xpath = "//span[contains(text(),'Select Menu')]")
    private WebElement selectMenuPage;

    public WidgetsMainPage(WebDriver driver) {
        super(driver);
        goToWidgets();
    }

    public WidgetsMainPage goToWidgets() {
        waitClickable(widgetsPage);
        widgetsPage.click();
        js.executeScript("arguments[0].scrollIntoView();", selectMenuPage);
        waitClickable(selectMenuPage);
        return this;
    }
}
