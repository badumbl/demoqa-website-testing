package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void init() {
        driver.get("https://demoqa.com/");
    }

    public void goToElement(String elem) {
        driver.findElement(By.xpath("//h5[contains(text(),'" + elem + "')]")).click();
    }

}
