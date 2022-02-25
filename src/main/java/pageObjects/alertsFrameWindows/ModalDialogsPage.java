package pageObjects.alertsFrameWindows;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalDialogsPage extends AlertsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Modal Dialogs')]")
    private WebElement modalDialogsPage;
    @FindBy(xpath = "//button[@id='showSmallModal']")
    private WebElement smallModal;
    @FindBy(xpath = "//button[@id='showLargeModal']")
    private WebElement largeModal;
    @FindBy(xpath = "//button[@id='closeSmallModal']")
    private WebElement closeSmallModal;
    @FindBy(xpath = "//button[@id='closeLargeModal']")
    private WebElement closeLargeModal;
    @FindBy(xpath = "//*[@class='modal-body']")
    private WebElement smallModalodalText;
    @FindBy(xpath = "//*[@class='modal-body']//p")
    private WebElement largeModalodalText;

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }

    public ModalDialogsPage go() {
        waitVisibility(modalDialogsPage);
        scrollIntoViewAndClick(modalDialogsPage);
        waitingElementOnPage(smallModal);
        return this;
    }

    public ModalDialogsPage small() {
        smallModal.click();
        waitVisibility(smallModalodalText);
        return this;
    }

    public ModalDialogsPage large() {
        largeModal.click();
        waitVisibility(largeModalodalText);
        return this;
    }

    public boolean isModalTextCorrect(ModalSize size, String text) {
        switch (size) {
            case SMALL:
                try {
                    return smallModalodalText.getText().equals(text);
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                    return false;
                } finally {
                    close(size);

                }
            case LARGE:
            default:
                try {
                    return largeModalodalText.getText().equals(text);
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                    return false;
                } finally {
                    close(size);
                }
        }
    }

    public void close(ModalSize size) {
        switch (size) {
            case SMALL:
                closeSmallModal.click();
                break;
            case LARGE:
            default:
                closeLargeModal.click();
                break;
        }
    }

    public enum ModalSize {
        SMALL, LARGE
    }
}
