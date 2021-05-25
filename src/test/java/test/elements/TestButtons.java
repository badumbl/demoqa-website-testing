package test.elements;

import objects.elements.Buttons;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestButtons extends HelperClass {

    private Buttons bt;
    private Actions actions;

    @BeforeClass
    public void init() {
        bt = new Buttons(getDriver());
        this.actions = new Actions(getDriver());
    }

    @Test(priority = 1)
    public void goToButtons() {
        bt.goButton().click();
    }

    @Test(priority = 2)
    public void checkDoubleClick() {
        actions.doubleClick(bt.doubleClick()).perform();
        Assert.assertEquals("You have done a double click",
                getDriver().findElement(By.xpath("//p[@id='doubleClickMessage']")).getText());

    }

    @Test(priority = 3)
    public void checkRightClick() {
        actions.contextClick(bt.rightClick()).perform();
        Assert.assertEquals("You have done a right click",
                getDriver().findElement(By.xpath("//p[@id='rightClickMessage']")).getText());
    }

    @Test(priority = 4)
    public void checkSingleClick() {
        bt.singleClick().click();
        Assert.assertEquals("You have done a dynamic click",
                getDriver().findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText());
    }

}
