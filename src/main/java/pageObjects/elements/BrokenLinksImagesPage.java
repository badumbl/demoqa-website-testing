package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenLinksImagesPage extends ElementsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Broken Links - Images')]")
    private WebElement brokenLinksPage;
    @FindBy(xpath = "//a[contains(text(),'Click Here for Broken Link')]")
    private WebElement brokenLink;
    @FindBy(xpath = "//p[contains(text(),'Valid image')]")
    private WebElement validImage;

    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    public BrokenLinksImagesPage goToBrokenLinks() {
        waitVisibility(brokenLinksPage);
        brokenLinksPage.click();
        waitingElementOnPage(validImage);
        return this;
    }

    public String brokenLink() {
        return brokenLink.getAttribute("href");
    }
}
