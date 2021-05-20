package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolTips {

    private WebDriver driver;

    public ToolTips(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Tool Tips')]"));
    }

    public WebElement hoverButton() {
        return driver.findElement(By.xpath("//button[@id='toolTipButton']"));
    }

    public WebElement hoverButtonText() {
        return driver.findElement(By.xpath("//div[@id='buttonToolTip']"));
    }

    public WebElement hoverField() {
        return driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
    }

    public WebElement hoverFieldText() {
        return driver.findElement(By.xpath("//div[@id='textFieldToolTip']"));
    }

    public WebElement hoverLinkOne() {
        return driver.findElement(By.xpath("//a[contains(text(),'Contrary')]"));
    }

    public WebElement hoverLinkOneText() {
        return driver.findElement(By.xpath("//div[@id='contraryTexToolTip']"));
    }

    public WebElement hoverLinkTwo() {
        return driver.findElement(By.xpath("//a[contains(text(),'1.10.32')]"));
    }

    public WebElement hoverLinkTwoText() {
        return driver.findElement(By.xpath("//div[@id='sectionToolTip']"));
    }

}
