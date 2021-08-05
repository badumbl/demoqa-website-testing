package objects.interactions;

import lombok.Data;
import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class Resizable extends BasePage {

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

    public Resizable(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public Resizable go() {
        resizablePage.click();
        js.executeScript("arguments[0].scrollIntoView();", resizeInside);
        waitVisibility(resizeInside);
        return this;
    }

    public Resizable dragAndDropOffset(WebElement source, int x, int y) {
        action.dragAndDropBy(source, x, y).perform();
        return this;
    }
}
