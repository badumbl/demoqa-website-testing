package objects.alertsFrameWindows;

import objects.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedFrames extends BasePage {

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

    public enum FramesAvailable {
        PARENT, CHILD
    }

    public NestedFrames(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public NestedFrames goTo() {
        nestedFramesPage.click();
        return this;
    }

    public NestedFrames parentFrame() {
        driver.switchTo().frame(parentFrame);
        return this;
    }

    public NestedFrames childFrame() {
        parentFrame();
        driver.switchTo().frame(childFrame);
        return this;
    }

    public NestedFrames mainFrame() {
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
