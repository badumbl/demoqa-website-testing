package objects.widgets;

import lombok.Data;
import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ToolTips extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Tool Tips')]")
    WebElement toolTipsPage;
    @FindBy(xpath = "//button[@id='toolTipButton']")
    WebElement hoverButton;
    @FindBy(xpath = "//div[@id='buttonToolTip']")
    WebElement hoverButtonText;
    @FindBy(xpath = "//input[@id='toolTipTextField']")
    WebElement hoverField;
    @FindBy(xpath = "//div[@id='textFieldToolTip']")
    WebElement hoverFieldText;
    @FindBy(xpath = "//a[contains(text(),'Contrary')]")
    WebElement hoverLinkOne;
    @FindBy(xpath = "//div[@id='contraryTexToolTip']")
    WebElement hoverLinkOneText;
    @FindBy(xpath = "//a[contains(text(),'1.10.32')]")
    WebElement hoverLinkTwo;
    @FindBy(xpath = "//div[@id='sectionToolTip']")
    WebElement hoverLinkTwoText;

    public ToolTips(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public ToolTips go() {
        //Scroll is needed, because footer blocks button on smaller monitors
        js.executeScript("window.scrollBy(0,250)");
        toolTipsPage.click();
        js.executeScript("arguments[0].scrollIntoView();", hoverButton);
        return this;
    }

    public ToolTips hoverButton() {
        action.moveToElement(hoverButton).perform();
        waitVisibility(hoverButtonText);
        return this;
    }


    public ToolTips hoverField() {
        action.moveToElement(hoverField).perform();
        waitVisibility(hoverFieldText);
        return this;
    }


    public ToolTips hoverLinkOne() {
        action.moveToElement(hoverLinkOne).perform();
        waitVisibility(hoverLinkOneText);
        return this;
    }


    public ToolTips hoverLinkTwo() {
        action.moveToElement(hoverLinkTwo).perform();
        waitVisibility(hoverLinkTwoText);
        return this;
    }


}
