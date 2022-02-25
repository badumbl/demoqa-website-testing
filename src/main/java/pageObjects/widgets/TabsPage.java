package pageObjects.widgets;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class TabsPage extends WidgetsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Tabs')]")
    private WebElement tabs;
    @FindBy(xpath = "//a[@id='demo-tab-what']")
    private WebElement whatButton;
    @FindBy(xpath = "//a[@id='demo-tab-origin']")
    private WebElement originButton;
    @FindBy(xpath = "//a[@id='demo-tab-use']")
    private WebElement useButton;
    @FindBy(xpath = "//a[@id='demo-tab-more']")
    private WebElement moreButton;
    @FindBy(xpath = "//div[@id='demo-tabpane-what']")
    private WebElement whatText;
    @FindBy(xpath = "//div[@id='demo-tabpane-origin']")
    private WebElement originText;
    @FindBy(xpath = "//div[@id='demo-tabpane-use']")
    private WebElement useText;

    public TabsPage(WebDriver driver) {
        super(driver);
    }

    public TabsPage go() {
        js.executeScript("window.scrollBy(0,250)");
        waitVisibility(tabs);
        tabs.click();
        waitingElementOnPage(whatButton);
        return this;
    }

    public TabsPage whatTab() {
        whatButton.click();
        waitVisibility(whatText);
        return this;
    }

    public TabsPage originTab() {
        originButton.click();
        waitVisibility(originText);
        return this;
    }


    public TabsPage useTab() {
        useButton.click();
        waitVisibility(useText);
        return this;
    }

    public boolean isButtonSelected(WebElement element) {
        return element.getAttribute("aria-selected").equals("true");
    }

    public boolean isTextVisible(WebElement element) {
        return element.getAttribute("class").equals("fade tab-pane active show");
    }

}
