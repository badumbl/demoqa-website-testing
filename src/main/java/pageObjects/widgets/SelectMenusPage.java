package pageObjects.widgets;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Data
public class SelectMenusPage extends WidgetsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Select Menu')]")
    private WebElement selectMenus;
    @FindBy(xpath = "//div[@id='withOptGroup']")
    private WebElement selectValue;
    @FindBy(css = "#withOptGroup div.css-1uccc91-singleValue")
    private WebElement selectedValue;
    @FindBy(xpath = "//div[@class=' css-11unzgr']//child::div[@tabindex='-1']")
    private List<WebElement> selectValueOptions;
    @FindBy(xpath = "//div[@id='selectOne']")
    private WebElement selectOne;
    @FindBy(css = "#selectOne div.css-1uccc91-singleValue")
    private WebElement selectedOne;
    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    private WebElement selectOld;
    @FindBy(xpath = "//select[@id='oldSelectMenu']//child::*")
    private List<WebElement> selectOldOptions;
    @FindBy(xpath = "//div[contains(text(),'Select...')]")
    private WebElement multiSelect;
    @FindBy(xpath = "//select[@id='cars']//child::*")
    private List<WebElement> standardMultiSelectOptions;
    @FindBy(xpath = "//select[@id='cars']")
    private WebElement standardMultiSelect;


    public SelectMenusPage(WebDriver driver) {
        super(driver);
    }

    public SelectMenusPage go() {
        js.executeScript("arguments[0].scrollIntoView();", selectMenus);
        selectMenus.click();
        waitingElementOnPage(selectValue);
        return this;
    }

    public SelectMenusPage selectValue(String selectValueOption) {
        selectValue.click();
        multiSelectHelper(helpIterate(selectValueOption, selectValueOptions));
        return this;
    }

    public SelectMenusPage selectOne(String selectOption) {
        selectOne.click();
        multiSelectHelper(helpIterate(selectOption, selectValueOptions));
        return this;
    }

    public SelectMenusPage selectOldStyle(String selectOption) {
        action.moveToElement(selectOld).click().perform();
        multiSelectHelper(helpIterate(selectOption, selectOldOptions));
        return this;
    }

    public SelectMenusPage multiSelect(String selectOption, String selectOption2) {
        multiSelect.click();
        multiSelectHelper(helpIterate(selectOption, selectValueOptions));
        multiSelectHelper(helpIterate(selectOption2, selectValueOptions));
        action.sendKeys(Keys.ESCAPE).perform();
        return this;
    }


    public SelectMenusPage standartMultiChoose(String selectOldOption, String selectOldOption2) {
        multiSelectHelper(helpIterate(selectOldOption, standardMultiSelectOptions));
        action
                .keyDown(Keys.LEFT_CONTROL)
                .moveToElement(helpIterate(selectOldOption2, standardMultiSelectOptions))
                .click()
                .release()
                .perform();
        return this;
    }

    private WebElement helpIterate(String selectValueOption, List<WebElement> list) {
        for (WebElement item : list) {
            if (item.getText().contains(selectValueOption)) {
                return item;
            }
        }
        return null;
    }

    private void multiSelectHelper(WebElement webElement2) {
        try {
            webElement2.click();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
