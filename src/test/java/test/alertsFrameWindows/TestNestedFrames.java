package test.alertsFrameWindows;

import objects.alertsFrameWindows.NestedFrames;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestNestedFrames extends HelperClass {

    private NestedFrames nf;

    @BeforeClass
    public void init() {
        nf = new NestedFrames(getDriver());
    }

    @Test(priority = 1)
    public void goToNestedFrames() {
        nf.goTo();
    }

    @Test(priority = 2)
    public void parentFrameTest() {
        nf.parentFrame();
        Assert.assertNotNull(getDriver().findElement(By.xpath("//*[contains(text(),'Parent frame')]")));
        nf.mainFrame();
    }

    @Test(priority = 2)
    public void childFrameTest() {
        nf.childFrame();
        Assert.assertEquals(getDriver().findElement(By.xpath("//*[contains(text(),'Child Iframe')]")).getText(),
                "Child Iframe");
        nf.mainFrame();
        nf.mainFrame();
    }


}
