package objects.alertsFrameWindows;

import objects.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frames extends BasePage {

    @FindBy(xpath = "//span[text() = 'Frames']")
    private WebElement framesPage;
    @FindBy(xpath = "//h1[@id='sampleHeading']")
    private WebElement textInFrame;


    public Frames(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public Frames go() {
        framesPage.click();
        return this;
    }

    public Frames big() {
        driver.switchTo().frame("frame1");
        return this;
    }

    public Frames small() {
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
