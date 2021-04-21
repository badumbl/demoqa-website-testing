package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsMenu {
    private final WebDriver driver;

    public ElementsMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void goToElementsMenu() {
        driver.findElement(By.xpath("//div[contains(text(),'Elements')]")).click();
    }
}


