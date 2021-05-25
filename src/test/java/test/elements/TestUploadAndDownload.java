package test.elements;

import objects.elements.UploadAndDownload;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestUploadAndDownload extends HelperClass {

    private UploadAndDownload ud;
    private String downloadPath = "C:\\Users\\ajva\\Downloads\\";
    private String fileName = "sampleFile.jpeg";
    private String toBeDeleted = downloadPath + fileName;
    private File f = new File(toBeDeleted);

    @BeforeClass
    public void init() {
        ud = new UploadAndDownload(getDriver());
    }

    @Test(priority = 1)
    public void goToUploadAndDownload() {
        //Scroll is needed, because footer blocks button on smaller monitors
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,250)");
        ud.goToUplAndDown().click();

    }

    @Test(priority = 2)
    public void download() {
        ud.download().click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        /*wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver wd) {
                return f.exists();
            }
        });*/
        wait.until((WebDriver wd) -> f.exists());

    }

    @Test(priority = 3)
    public void upload() {
        ud.upload().sendKeys(toBeDeleted);
        Assert.assertEquals(getDriver().findElement(By.xpath("//p[@id='uploadedFilePath']")).getText(),
                "C:\\fakepath\\" + fileName);
        Assert.assertTrue(f.delete());
    }
}
