package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Widgets {

    private WebDriver driver;

    public Widgets(WebDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.findElement(By.xpath("//div[contains(text(), 'Widgets')]")).click();
    }
}
