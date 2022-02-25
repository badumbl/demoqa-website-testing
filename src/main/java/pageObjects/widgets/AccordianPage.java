package pageObjects.widgets;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class AccordianPage extends WidgetsMainPage {

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

    public AccordianPage(WebDriver driver) {
        super(driver);
    }

    public AccordianPage go() {
        waitVisibility(accordianPage);
        accordianPage.click();
        waitingElementOnPage(whatIsSection);
        return this;
    }

    public AccordianPage whatIs() {
        whatIsSection.click();
        waitingClassValue(whatIsContent,CLASS_VALUE);
        return this;
    }

    public AccordianPage whereDoes() {
        action.moveToElement(whereDoesSection);
        whereDoesSection.click();
        waitingClassValue(whereDoesContent,CLASS_VALUE);
        return this;
    }

    public AccordianPage whyDo() {
        whyDoSection.click();
        waitingClassValue(whyDoContent,CLASS_VALUE);
        return this;
    }
}
