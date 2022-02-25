package pageObjects.alertsFrameWindows;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFramesPage extends AlertsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Nested Frames')]")
    private WebElement nestedFramesPage;
    @FindBy(xpath = "//iframe[@id='frame1']")
    private WebElement parentFrame;
    @FindBy(xpath = "//body/iframe[1]")
    private WebElement childFrame;
    @FindBy(xpath = "//body")
    private WebElement parentFrameText;
    @FindBy(xpath = "//body//p")
    private WebElement childFrameText;
    @FindBy(xpath = "//div[contains(text(),'Sample Nested Iframe page. There are nested iframe')]")
    private WebElement mainFrame;

    public enum FramesAvailable {
        PARENT, CHILD
    }

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public NestedFramesPage goTo() {
        waitVisibility(nestedFramesPage);
        nestedFramesPage.click();
        waitingElementOnPage(mainFrame);
        return this;
    }

    public NestedFramesPage parentFrame() {
        driver.switchTo().frame(parentFrame);
        return this;
    }

    public NestedFramesPage childFrame() {
        parentFrame();
        driver.switchTo().frame(childFrame);
        return this;
    }

    public NestedFramesPage mainFrame() {
        driver.switchTo().parentFrame();
        return this;
    }

    public boolean isTextCorrect(FramesAvailable frame, String text) {
        switch (frame) {
            case PARENT:
                try {
                    return parentFrameText.getText().equals(text);
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                    return false;
                } finally {
                    mainFrame();
                }

            case CHILD:
            default:
                try {
                    return childFrameText.getText().equals(text);
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                    return false;
                } finally {
                    mainFrame();
                }
        }
    }
}
