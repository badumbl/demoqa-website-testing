package test.alertsFrameWindows;

import objects.alertsFrameWindows.AlFrWi;
import objects.alertsFrameWindows.NestedFrames;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestNestedFrames extends BaseTest {

    private NestedFrames nestedFramesPage;
    private AlFrWi afw;
    private static final String PARENT_TEXT = "Parent frame";
    private static final String CHILD_TEXT = "Child Iframe";

    @BeforeClass
    public void init() {
        nestedFramesPage = new NestedFrames(driver);
        super.passMainPage();
        afw = new AlFrWi(driver);
    }

    @Test(priority = 1)
    public void goToNestedFrames() {
        afw.go();
        nestedFramesPage.goTo();
    }

    @Test(priority = 2)
    public void parentFrameTest() {
        Assert.assertTrue(
                nestedFramesPage
                        .parentFrame()
                        .isTextCorrect(NestedFrames.FramesAvailable.PARENT, PARENT_TEXT)
        );
    }

    @Test(priority =3)
    public void childFrameTest() {
        Assert.assertTrue(
                nestedFramesPage
                        .childFrame()
                        .isTextCorrect(NestedFrames.FramesAvailable.CHILD, CHILD_TEXT)
        );
    }
}
