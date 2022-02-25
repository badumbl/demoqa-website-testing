package test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.elements.UploadAndDownloadPage;
import test.BaseTest;

import java.io.File;

public class TestUploadAndDownloadPage extends BaseTest {

    private UploadAndDownloadPage uplDownlPage;
    private final static String downloadPath = "C:\\Users\\ajva\\Downloads\\";
    private final static String fileName = "sampleFile.jpeg";
    private final static String toBeDeleted = downloadPath + fileName;
    private final static File FILE = new File(toBeDeleted);

    @BeforeClass
    public void init() {
        uplDownlPage = new UploadAndDownloadPage(driver);
    }

    @Test(priority = 1)
    public void goToUploadAndDownload() {
        uplDownlPage.goToUplAndDown();
    }

    @Test(priority = 2)
    public void download() {
        Assert.assertTrue(
                uplDownlPage
                        .download()
                        .isDownloaded(FILE)
        );
    }

    @Test(priority = 3)
    public void upload() {
        Assert.assertTrue(
                uplDownlPage
                        .upload(toBeDeleted)
                        .isUploaded(fileName)
        );
        Assert.assertTrue(FILE.delete());
    }
}
