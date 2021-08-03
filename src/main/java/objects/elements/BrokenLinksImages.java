package objects.elements;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrokenLinksImages extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Broken Links - Images')]")
    private WebElement brokenLinksPage;
    @FindBy(xpath = "//a[contains(text(),'Click Here for Broken Link')]")
    private WebElement brokenLink;

    public BrokenLinksImages(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public BrokenLinksImages goToBrokenLinks() {
        brokenLinksPage.click();
        return this;
    }

    public String brokenLink() {
        return brokenLink.getAttribute("href");
    }
}
