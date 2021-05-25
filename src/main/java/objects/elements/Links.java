package objects.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Links {

    private WebDriver driver;
    private WebElement element;

    public Links(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement start() {
        return driver.findElement(By.xpath("//span[contains(text(),'Links')]"));
    }

    public WebElement newTabLink() {
        return driver.findElement(By.xpath("//a[@id='simpleLink']"));
    }
}


