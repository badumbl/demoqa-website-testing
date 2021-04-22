package test.elements;

import objects.elements.Buttons;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestButtons extends HelperClass {

    private Buttons bt;

    @Test(priority = 1)
    public void goToButtons() {
        bt = new Buttons(getDriver());
        bt.goButton();
    }

    @Test(priority = 2)
    public void checkDoubleClick() {
        bt.doubleClick();
        Assert.assertEquals("You have done a double click",
                getDriver().findElement(By.xpath("//p[@id='doubleClickMessage']")).getText());

    }

    @Test(priority = 3)
    public void checkRightClick() {
        bt.rightClick();
        Assert.assertEquals("You have done a right click",
                getDriver().findElement(By.xpath("//p[@id='rightClickMessage']")).getText());
    }

    @Test(priority = 4)
    public void checkSingleClick() {
        bt.singleClick();
        Assert.assertEquals("You have done a dynamic click",
                getDriver().findElement(By.xpath("//p[@id='dynamicClickMessage']")).getText());
    }

}
