package test.alertsFrameWindows;

import objects.alertsFrameWindows.AlFrWi;
import objects.alertsFrameWindows.Frames;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestFrames extends BaseTest {

    private Frames framesPage;
    private AlFrWi afw;
    private static final String textToCheck = "This is a sample page";

    @BeforeClass
    public void init() {
        framesPage = new Frames(driver);
        super.passMainPage();
        afw = new AlFrWi(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        afw.go();
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
