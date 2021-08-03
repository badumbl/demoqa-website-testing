package objects.widgets;

import lombok.Data;
import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Data
public class AutoComplete extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Auto Complete')]")
    private WebElement autoCompletePage;
    @FindBy(xpath = "//div[@id='autoCompleteMultipleContainer']")
    private WebElement autoCompleteMultiField;
    @FindBy(xpath = "//div[@id='autoCompleteSingleContainer']")
    private WebElement autoCompleteSingleField;
    @FindBy(xpath = "//div[@class='auto-complete__menu-list auto-complete__menu-list--is-multi css-11unzgr']/child::*")
    private List<WebElement> multiList;
    @FindBy(xpath = "//div[@class='auto-complete__menu-list css-11unzgr']/child::*")
    private List<WebElement> singleList;


    public AutoComplete(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public AutoComplete go() {
        autoCompletePage.click();
        return this;
    }

    public AutoComplete multiColor(String s) {
        autoCompleteMultiField.click();
        action.sendKeys(s).build().perform();
        return this;
    }

    public AutoComplete singleColor(String s) {
        autoCompleteSingleField.click();
        action.sendKeys(s).build().perform();
        return this;
    }

    public AutoComplete selectOption(List<WebElement> list, Integer i) {
        list.get(i).click();
        return this;
    }


}
