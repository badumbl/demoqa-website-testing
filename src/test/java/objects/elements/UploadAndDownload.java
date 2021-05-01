package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadAndDownload {

    private WebDriver driver;

    public UploadAndDownload(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUplAndDown() {
        //Scroll is needed, because footer blocks button on smaller monitors
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//span[contains(text(),'Upload and Download')]")).click();
    }

    public void download() {
        driver.findElement(By.xpath("//a[@id='downloadButton']")).click();
    }

    public void upload(String toBeDeleted) {
        driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys(toBeDeleted);
       /* elem.click();
        elem.sendKeys(toBeDeleted);*/
    }
}
