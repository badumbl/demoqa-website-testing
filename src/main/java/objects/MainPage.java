package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {


    public MainPage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
        //Scroll is needed, because footer blocks button on smaller monitors
        js.executeScript("window.scrollBy(0,250)");
    }

    public WebElement goToElement(String elem) {
        return driver.findElement(By.xpath("//h5[contains(text(),'" + elem + "')]"));
    }
}
