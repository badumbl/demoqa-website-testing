package pageObjects.widgets;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ToolTipsPage extends WidgetsMainPage {

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
    @FindBy(xpath = "//p[contains(text(),'Practice Tool Tips')]")
    WebElement naming;


    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    public ToolTipsPage go() {
        scrollIntoViewAndClick(toolTipsPage);
        waitingElementOnPage(naming);
        return this;
    }

    public ToolTipsPage hoverButton() {
        action.moveToElement(hoverField).perform();
        action.click(hoverField).perform();
        action.moveToElement(hoverButton).perform();
        waitVisibility(hoverButtonText);
        return this;
    }


    public ToolTipsPage hoverField() {
        action.moveToElement(hoverField).perform();
        waitVisibility(hoverFieldText);
        return this;
    }


    public ToolTipsPage hoverLinkOne() {
        action.moveToElement(hoverLinkOne).perform();
        waitVisibility(hoverLinkOneText);
        return this;
    }


    public ToolTipsPage hoverLinkTwo() {
        action.moveToElement(hoverLinkTwo).perform();
        waitVisibility(hoverLinkTwoText);
        return this;
    }


}
