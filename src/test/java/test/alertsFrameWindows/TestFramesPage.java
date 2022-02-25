package test.alertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.alertsFrameWindows.FramesPage;
import test.BaseTest;

public class TestFramesPage extends BaseTest {

    private FramesPage framesPage;
    private static final String textToCheck = "This is a sample page";

    @BeforeClass
    public void init() {
        framesPage = new FramesPage(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        framesPage.go();
    }

    @Test(priority = 2)
    public void bigFrame() {
        Assert.assertTrue(
                framesPage
                        .big()
                        .isTextRight(textToCheck)
        );
    }

    @Test(priority = 2)
    public void smallFrame() {
        Assert.assertTrue(
                framesPage
                        .small()
                        .isTextRight(textToCheck)
        );
    }
}
