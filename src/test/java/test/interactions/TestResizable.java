package test.interactions;

import objects.interactions.Resizable;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestResizable extends HelperClass {

    private Resizable res;
    private Actions action;

    @BeforeClass
    public void init() {
        res = new Resizable(getDriver());
        action = new Actions(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        res.go().click();
    }

    @Test(priority = 2)
    public void resizeBoxInside() {
        action.dragAndDropBy(res.resizeInside(), 350, 150).perform();
        Assert.assertEquals(getDriver()
                .findElement(By.xpath("//div[@id='resizableBoxWithRestriction']"))
                .getAttribute("style"), "width: 500px; height: 300px;");
        action.dragAndDropBy(res.resizeInside(), -400, -400).perform();
        Assert.assertEquals(getDriver()
                .findElement(By.xpath("//div[@id='resizableBoxWithRestriction']"))
                .getAttribute("style"), "width: 150px; height: 150px;");
    }

    @Test(priority = 2)
    public void resizeBoxOutside() {
        String before = getDriver().findElement(By.xpath("//div[@id='resizable']")).getAttribute("style");
        action.dragAndDropBy(res.resizeOutside(), 350, 150).perform();
        Assert.assertNotEquals(getDriver()
                .findElement(By.xpath("//div[@id='resizable']"))
                .getAttribute("style"), before);
    }

}
