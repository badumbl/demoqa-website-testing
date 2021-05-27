package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Accordian {

    private WebDriver driver;

    public Accordian(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Accordian')]"));
    }

    public WebElement whatIs() {
        return driver.findElement(By.xpath("//div[@id='section1Heading']"));
    }

    public WebElement whereDoes() {
        return driver.findElement(By.xpath("//div[@id='section2Heading']"));
    }

    public WebElement whyDo() {
        return driver.findElement(By.xpath("//div[@id='section3Heading']"));
    }
}
