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

    public void start() {
        driver.findElement(By.xpath("//span[contains(text(),'Links')]")).click();
    }

    public void newTabLink() {
        driver.findElement(By.xpath("//a[@id='simpleLink']")).click();
    }
}


