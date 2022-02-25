package pageObjects.interactions;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ResizablePage extends InteractionsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Resizable')]")
    private WebElement resizablePage;
    @FindBy(xpath = "//div[@id='resizableBoxWithRestriction']//child::span")
    private WebElement resizeInside;
    @FindBy(xpath = "//div[@id='resizable']//child::span")
    private WebElement resizeOutside;
    @FindBy(xpath = "//div[@id='resizableBoxWithRestriction']")
    private WebElement resizableRestrictions;
    @FindBy(xpath = "//div[@id='resizable']")
    private WebElement resizable;

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public ResizablePage go() {
        waitVisibility(resizablePage);
        resizablePage.click();
        waitingElementOnPage(resizeInside);
        return this;
    }

    public ResizablePage dragAndDropOffset(WebElement source, int x, int y) {
        action.moveToElement(source);
        action.dragAndDropBy(source, x, y).perform();
        return this;
    }
}
