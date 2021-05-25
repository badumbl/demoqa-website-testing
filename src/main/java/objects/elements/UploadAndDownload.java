package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadAndDownload {

    private WebDriver driver;

    public UploadAndDownload(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToUplAndDown() {
       return  driver.findElement(By.xpath("//span[contains(text(),'Upload and Download')]"));
    }

    public WebElement download() {
       return driver.findElement(By.xpath("//a[@id='downloadButton']"));
    }

    public WebElement upload() {
       return driver.findElement(By.xpath("//input[@id='uploadFile']"));

    }
}
