package objects.elements;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadAndDownload extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Upload and Download')]")
    private WebElement uploadDownloadPage;
    @FindBy(xpath = "//a[@id='downloadButton']")
    private WebElement downloadButton;
    @FindBy(xpath = "//input[@id='uploadFile']")
    private WebElement uploadButton;
    @FindBy(xpath = "//p[@id='uploadedFilePath']")
    private WebElement uploadText;

    public UploadAndDownload(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public UploadAndDownload goToUplAndDown() {
        uploadDownloadPage.click();
        return this;
    }

    public UploadAndDownload download() {
        downloadButton.click();
        return this;
    }

    public UploadAndDownload upload(String path) {
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
