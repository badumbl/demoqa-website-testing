package objects.widgets;

import lombok.Data;
import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Data
public class Tabs extends BasePage {

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

    public Tabs(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public Tabs go() {
        js.executeScript("window.scrollBy(0,250)");
        tabs.click();
        return this;
    }

    public Tabs whatB() {
        whatButton.click();
        waitVisibility(whatText);
        return this;
    }

    public Tabs originB() {
        originButton.click();
        waitVisibility(originText);
        return this;
    }


    public Tabs useB() {
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
