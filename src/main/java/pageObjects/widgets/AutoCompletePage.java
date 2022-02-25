package pageObjects.widgets;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Data
public class AutoCompletePage extends WidgetsMainPage {

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


    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    public AutoCompletePage go() {
        waitVisibility(autoCompletePage);
        autoCompletePage.click();
        waitingElementOnPage(autoCompleteMultiField);
        return this;
    }

    public AutoCompletePage multiColor(String s) {
        autoCompleteMultiField.click();
        action.sendKeys(s).build().perform();
        return this;
    }

    public AutoCompletePage singleColor(String s) {
        autoCompleteSingleField.click();
        action.sendKeys(s).build().perform();
        return this;
    }

    public AutoCompletePage selectOption(List<WebElement> list, Integer i) {
        list.get(i).click();
        return this;
    }


}
