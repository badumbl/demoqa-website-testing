package pageObjects.elements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class LinksPage extends ElementsMainPage {
    @FindBy(xpath = "//span[contains(text(),'Links')]")
    private WebElement linksPage;
    @FindBy(xpath = "//a[@id='simpleLink']")
    private WebElement newTabLink;
    @FindBy(xpath = "//a[@id='created']")
    private WebElement createdCall;
    @FindBy(xpath = "//a[@id='no-content']")
    private WebElement noContetntCall;
    @FindBy(xpath = "//a[@id='moved']")
    private WebElement movedCall;
    @FindBy(xpath = "//a[@id='bad-request']")
    private WebElement badRequestCall;
    @FindBy(xpath = "//a[@id='unauthorized']")
    private WebElement unauthorizedCall;
    @FindBy(xpath = "//a[@id='forbidden']")
    private WebElement forbiddenCall;
    @FindBy(xpath = "//a[@id='invalid-url']")
    private WebElement notFoundCall;
    @FindBy(xpath = "//p[@id='linkResponse']")
    private WebElement linkResponseText;

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public LinksPage start() {
        waitVisibility(linksPage);
        js.executeScript("arguments[0].scrollIntoView();", linksPage);
        linksPage.click();
        waitingElementOnPage(newTabLink);
        return this;
    }

    public LinksPage newTabLink() {
        newTabLink.click();
        return this;
    }

    public LinksPage switchBetweenTabs(int i) {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(i));
        return this;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}


