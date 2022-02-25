package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadAndDownloadPage extends ElementsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Upload and Download')]")
    private WebElement uploadDownloadPage;
    @FindBy(xpath = "//a[@id='downloadButton']")
    private WebElement downloadButton;
    @FindBy(xpath = "//input[@id='uploadFile']")
    private WebElement uploadButton;
    @FindBy(xpath = "//p[@id='uploadedFilePath']")
    private WebElement uploadText;

    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    public UploadAndDownloadPage goToUplAndDown() {
        waitVisibility(uploadDownloadPage);
        uploadDownloadPage.click();
        waitingElementOnPage(downloadButton);
        return this;
    }

    public UploadAndDownloadPage download() {
        downloadButton.click();
        return this;
    }

    public UploadAndDownloadPage upload(String path) {
        uploadButton.sendKeys(path);
        return this;
    }

    public boolean isUploaded(String fileName) {
        return uploadText.getText().equals("C:\\fakepath\\" + fileName);
    }

    public boolean isDownloaded(File f) {
        waitingExists(f);
        return f.exists();
    }

}
