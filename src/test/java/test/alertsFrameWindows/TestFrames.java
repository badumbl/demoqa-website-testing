package test.alertsFrameWindows;

import objects.alertsFrameWindows.Frames;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestFrames extends HelperClass {

    private Frames fr;

    @BeforeClass
    public void init() {
        fr = new Frames(getDriver());

    }

    @Test(priority = 1)
    public void goTo() {
        fr.go().click();
    }

    @Test(priority = 2)
    public void bigFrame() {
        fr.big();
        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[@id='sampleHeading']")).getText(),
                "This is a sample page");
        fr.mainFrame();
    }

    @Test(priority = 2)
    public void smallFrame() {
        fr.small();
        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[@id='sampleHeading']")).getText(),
                "This is a sample page");
        fr.mainFrame();
    }

}
