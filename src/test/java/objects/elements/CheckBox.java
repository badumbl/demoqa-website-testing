package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {

    WebDriver driver;

    public CheckBox(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCheckBox() {
        driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
    }

    //TBD
    public void checkReact() {
        driver.findElement(By.xpath("//li/span[@class='rct-text']/*[@class='rct-collapse rct-collapse-btn']")).click();
        //span[contains(text(),'React')]/../span/*[@class='rct-icon rct-icon-check']

    }
}
