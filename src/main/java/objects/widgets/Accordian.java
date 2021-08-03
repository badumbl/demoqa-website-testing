package objects.widgets;

import lombok.Data;
import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class Accordian extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Accordian')]")
    private WebElement accordianPage;
    @FindBy(xpath = "//div[@id='section1Heading']")
    private WebElement whatIsSection;
    @FindBy(xpath = "//div[@id='section1Heading']/following-sibling::div")
    private WebElement whatIsContent;
    @FindBy(xpath = "//div[@id='section2Heading']")
    private WebElement whereDoesSection;
    @FindBy(xpath = "//div[@id='section2Heading']/following-sibling::div")
    private WebElement whereDoesContent;
    @FindBy(xpath = "//div[@id='section3Heading']")
    private WebElement whyDoSection;
    @FindBy(xpath = "//div[@id='section3Heading']/following-sibling::div")
    private WebElement whyDoContent;
    private final static String CLASS_VALUE = "collapse show";

    public Accordian(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public Accordian go() {
        accordianPage.click();
        return this;
    }

    public Accordian whatIs() {
        whatIsSection.click();
        waitingClassValue(whatIsContent,CLASS_VALUE);
        return this;
    }

    public Accordian whereDoes() {
        whereDoesSection.click();
        waitingClassValue(whereDoesContent,CLASS_VALUE);
        return this;
    }

    public Accordian whyDo() {
        whyDoSection.click();
        waitingClassValue(whyDoContent,CLASS_VALUE);
        return this;
    }
}
