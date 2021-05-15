package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AutoComplete {

    private WebDriver driver;
    private Actions actions;
    private List<WebElement> list;

    public AutoComplete(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void go() {
        driver.findElement(By.xpath("//span[contains(text(),'Auto Complete')]")).click();
    }

    public List<WebElement> multiColor(String s) {
        WebElement elem = driver.findElement(By
                .xpath("//div[@id='autoCompleteMultipleContainer']"));
        elem.click();
        actions.sendKeys(s).build().perform();
        list = driver.findElements(By
                .xpath("//div[@class='auto-complete__menu-list auto-complete__menu-list--is-multi css-11unzgr']/child::*"));
        return list;
    }

    public List<WebElement> singleColor(String s) {
        WebElement elem = driver.findElement(By
                .xpath("//div[@id='autoCompleteSingleContainer']"));
        elem.click();
        actions.sendKeys(s).build().perform();
        list = driver.findElements(By
                .xpath("//div[@class='auto-complete__menu-list css-11unzgr']/child::*"));
        return list;

    }

    public void selectOption(Integer i){
        list.get(i).click();
    }


}
