package test.widgets;

import objects.widgets.SelectMenus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestSelectMenus extends HelperClass {

    private SelectMenus me;
    private Actions action;
    private JavascriptExecutor jse;
    private String selectValueOption = "Group 2, option 1";
    private String selectOneOption = "Prof.";
    private String selectOldOption = "Indigo";
    private String selectStandardMultiOption1 = "Saab";
    private String selectStandardMultiOption2 = "Audi";

    @BeforeClass
    public void init() {
        me = new SelectMenus(getDriver());
        action = new Actions(getDriver());
        jse = (JavascriptExecutor) getDriver();
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
        if (me.selectValueChoose(selectValueOption) != null) {
            me.selectValueChoose(selectValueOption).click();
        } else {
            System.out.println("Element not found");
        }
    }

    @Test(priority = 3)
    public void selectOneMenu() {
        action.moveToElement(me.selectOne()).click().perform();
        if (me.selectValueChoose(selectOneOption) != null) {
            me.selectValueChoose(selectOneOption).click();
        } else {
            System.out.println("Element not found");
        }
    }

    @Test(priority = 3)
    public void oldStyleSelectMenu() {
        action.moveToElement(me.oldStyle()).click().perform();
        if (me.selectOldStyle(selectOldOption) != null) {
            me.selectOldStyle(selectOldOption).click();
        } else {
            System.out.println("Element not found");
        }

    }

    @Test(priority = 3)
    public void multiSelectMenu() {
        //   me.multiSelect();
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
}
