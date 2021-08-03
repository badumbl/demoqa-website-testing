package test.widgets;

import objects.widgets.SelectMenus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestSelectMenus extends BaseTest {

    private SelectMenus me;
    private Actions action;
    private JavascriptExecutor jse;
    private String selectValueOption = "Group 2, option 1";
    private String selectOneOption = "Prof.";
    private String selectOldOption = "Indigo";
    private String selectStandardMultiOption1 = "Saab";
    private String selectStandardMultiOption2 = "Audi";
    private String selectMulti1 = "Green";
    private String selectMulti2 = "Black";

    @BeforeClass
    public void init() {
        me = new SelectMenus(driver);
        action = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    @Test(priority = 1)
    public void goTo() {
        //Scroll is needed, because footer blocks button on smaller monitors
        jse.executeScript("window.scrollBy(0,250)");
        me.go().click();
    }

    @Test(priority = 2)
    public void selectValueMenu() {
        jse.executeScript("arguments[0].scrollIntoView();", me.selectValue());
        action.moveToElement(me.selectValue()).click().perform();
        multiSelectHelper(me.selectValueChoose(selectValueOption));
    }

    @Test(priority = 3)
    public void selectOneMenu() {
        action.moveToElement(me.selectOne()).click().perform();
        multiSelectHelper(me.selectValueChoose(selectOneOption));
    }

    @Test(priority = 3)
    public void oldStyleSelectMenu() {
        action.moveToElement(me.oldStyle()).click().perform();
        multiSelectHelper(me.selectOldStyle(selectOldOption));

    }


    @Test(priority = 4)
    public void multiSelectMenu() {
        action.moveToElement(me.multiSelect()).click().perform();
        multiSelectHelper(me.selectValueChoose(selectMulti1));
        multiSelectHelper(me.selectValueChoose(selectMulti2));
        action.sendKeys(Keys.ESCAPE).perform();
    }

    @Test(priority = 3)
    public void standartMultiSelectMenu() {
        if (me.standartMultiChoose(selectStandardMultiOption1) != null &&
                me.standartMultiChoose(selectStandardMultiOption2) != null) {
            me.standartMultiChoose(selectStandardMultiOption1).click();
            action
                    .keyDown(Keys.LEFT_CONTROL)
                    .moveToElement(me.standartMultiChoose(selectStandardMultiOption2))
                    .click()
                    .release()
                    .perform();
        } else {
            System.out.println("Element not found");
        }
    }

    private void multiSelectHelper(WebElement webElement2) {
        if (webElement2 != null) {
            webElement2.click();
        } else {
            System.out.println("Element not found");
        }
    }
}
