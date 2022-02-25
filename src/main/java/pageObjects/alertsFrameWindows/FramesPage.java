package pageObjects.alertsFrameWindows;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends AlertsMainPage {

    @FindBy(xpath = "//span[text() = 'Frames']")
    private WebElement framesPage;
    @FindBy(xpath = "//h1[@id='sampleHeading']")
    private WebElement textInFrame;
    @FindBy(xpath = "//div[contains(text(),'Frames')]")
    private WebElement frames;


    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public FramesPage go() {
        waitClickable(framesPage);
        framesPage.click();
        js.executeScript("arguments[0].scrollIntoView();", frames);
        return this;
    }

    public FramesPage big() {
        driver.switchTo().frame("frame1");
        return this;
    }

    public FramesPage small() {
        driver.switchTo().frame("frame2");
        return this;
    }

    public void mainFrame() {
        driver.switchTo().parentFrame();
    }

    public boolean isTextRight(String text) {
        try {
            return textInFrame.getText().equals(text);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        } finally {
            mainFrame();
        }
    }
}
