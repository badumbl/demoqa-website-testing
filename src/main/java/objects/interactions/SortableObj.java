package objects.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SortableObj {

    private WebDriver driver;
    private List<WebElement> list;
    private List<WebElement> grid;

    public SortableObj(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Sortable')]"));
    }

    public WebElement goToList() {
        return driver.findElement(By.xpath("//a[@id='demo-tab-list']"));
    }

    public WebElement getFromList(String name) {
        list = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='vertical-list-container mt-4']//child::*"));
        for (WebElement elem : list) {
            if (elem.getText().contains(name)) {
                return elem;
            }
        }
        return null;
    }

    public WebElement goToGrid() {
        return driver.findElement(By.xpath("//a[@id='demo-tab-grid']"));
    }

    public WebElement getFromGrid(String name) {
        grid = driver.findElements(By.xpath("//div[@id='demo-tabpane-grid']//div[@class='create-grid']//child::*"));
        for (WebElement elem : grid) {
            if (elem.getText().contains(name)) {
                return elem;
            }
        }
        return null;
    }

}


