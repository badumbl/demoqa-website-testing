package objects.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Droppable {

    private WebDriver driver;

    public Droppable(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Droppable')]"));
    }

    public WebElement simpleObj() {
        return driver.findElement(By.xpath("//div[@id='draggable']"));
    }

    public WebElement simpleTarget() {
        return driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
    }

    public WebElement goAccept() {
        return driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
    }

    public WebElement acceptObj() {
        return driver.findElement(By.xpath("//div[@id='acceptable']"));
    }

    public WebElement acceptTarget() {
        return driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));

    }

    public WebElement notAcceptObj() {
        return driver.findElement(By.xpath("//div[@id='notAcceptable']"));
    }


    public WebElement goPrevProp() {
        return driver.findElement(By.xpath("//a[@id='droppableExample-tab-preventPropogation']"));

    }

    public WebElement dragBox() {
        return driver.findElement(By.xpath("//div[@id='dragBox']"));

    }

    public WebElement outNotGreedy() {
        return driver.findElement(By.xpath("//div[@id='notGreedyDropBox']"));

    }

    public WebElement innerNotGreedy() {
        return driver.findElement(By.xpath("//div[@id='notGreedyInnerDropBox']"));

    }

    public WebElement outGreedy() {
        return driver.findElement(By.xpath("//div[@id='greedyDropBox']"));
    }

    public WebElement outGreedyChild() {
        return driver.findElement(By.xpath("//div[@id='greedyDropBox']//child::*"));
    }

    public WebElement innerGreedy() {
        return driver.findElement(By.xpath("//div[@id='greedyDropBoxInner']"));

    }

    public WebElement goRevert() {
        return driver.findElement(By.xpath("//a[@id='droppableExample-tab-revertable']"));
    }

    public WebElement revertable() {
        return driver.findElement(By.xpath("//div[@id='revertable']"));
    }

    public WebElement notRevertable() {
        return driver.findElement(By.xpath("//div[@id='notRevertable']"));
    }

    public WebElement dropBox() {
        return driver.findElement(By.xpath("//div[@id='revertableDropContainer']//div[@id='droppable']"));
    }


}
