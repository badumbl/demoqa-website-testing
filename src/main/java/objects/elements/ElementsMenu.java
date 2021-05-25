package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsMenu {
    private final WebDriver driver;

    public ElementsMenu(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToElementsMenu() {
       return driver.findElement(By.xpath("//div[contains(text(),'Elements')]"));
    }
}


