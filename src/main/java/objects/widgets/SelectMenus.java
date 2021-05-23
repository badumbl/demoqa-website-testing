package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SelectMenus {

    private WebDriver driver;
    private List<WebElement> list;
    private List<WebElement> oldList;
    private List<WebElement> standartMulitlist;

    public SelectMenus(WebDriver driver) {
        this.driver = driver;
        list = new ArrayList<>();
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Select Menu')]"));
    }

    public WebElement selectValue() {
        return driver.findElement(By.xpath("//div[@id='withOptGroup']"));
    }

    public WebElement selectValueChoose(String selectValueOption) {
        list = driver.findElements(By.xpath("//div[@class=' css-11unzgr']//child::div[@tabindex='-1']"));
        for (WebElement elem : list) {
            System.out.println(elem.getText());
        }
        return helpIterate(selectValueOption, list);
    }


    public WebElement selectOne() {
        return driver.findElement(By.xpath("//div[@id='selectOne']"));
    }

    public WebElement oldStyle() {
        return driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

    }

    public WebElement selectOldStyle(String selectOldOption) {
        standartMulitlist = driver.findElements(By.xpath("//select[@id='oldSelectMenu']//child::*"));
        return helpIterate(selectOldOption, standartMulitlist);
    }

    public WebElement multiSelect() {
        return driver.findElement(By.xpath("//div[contains(text(),'Select...')]"));

    }

    public WebElement standartMulti() {
        return driver.findElement(By.xpath("//select[@id='cars']"));
    }

    public WebElement standartMultiChoose(String selectOldOption) {
        oldList = driver.findElements(By.xpath("//select[@id='cars']//child::*"));
        return helpIterate(selectOldOption, oldList);

    }

    private WebElement helpIterate(String selectValueOption, List<WebElement> list) {
        for (WebElement item : list) {
            if (item.getText().contains(selectValueOption)) {
                return item;
            }
        }
        return null;
    }
}
