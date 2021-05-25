package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {

    WebDriver driver;

    public CheckBox(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToCheckBox() {
       return  driver.findElement(By.xpath("//span[contains(text(),'Check Box')]"));
    }


    public void checkReact() {
        driver.findElement(By.xpath("//li/span[@class='rct-text']/*[@class='rct-collapse rct-collapse-btn']")).click();
        driver.findElement(By.xpath("//*[@id='tree-node-desktop']/../../*[@class='rct-collapse rct-collapse-btn']")).click();
        driver.findElement(By.xpath("//*[@id='tree-node-documents']/../../*[@class='rct-collapse rct-collapse-btn']")).click();
        driver.findElement(By.xpath("//*[@id='tree-node-workspace']/../../*[@class='rct-collapse rct-collapse-btn']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'React')]/../span")).click();


    }
}
