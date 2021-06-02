package objects.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectableObj {

    private WebDriver driver;

    public SelectableObj(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Selectable')]"));
    }

    public WebElement goToList() {
        return driver.findElement(By.xpath("//a[@id='demo-tab-list']"));
    }

    public WebElement goToGrid() {
        return driver.findElement(By.xpath("//a[@id='demo-tab-grid']"));
    }

    public List<WebElement> getList() {
        return driver.findElements(By.xpath("//ul[@id='verticalListContainer']//child::*"));
    }

    public List<WebElement> getGrid() {
        return driver.findElements(By.xpath("//div[@id='gridContainer']//child::li[@class='list-group-item list-group-item-action']"));
    }


}
