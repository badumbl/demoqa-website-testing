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
        WebElement elem = driver.findElement(By.xpath("//span[contains(text(),'Accordian')]"));
        return elem;
    }

    public void whatIs() {
        driver.findElement(By.xpath("//div[@id='section1Heading']")).click();
    }

    public void whereDoes() {
        driver.findElement(By.xpath("//div[@id='section2Heading']")).click();
    }

    public void whyDo() {
        driver.findElement(By.xpath("//div[@id='section3Heading']")).click();
    }
}
