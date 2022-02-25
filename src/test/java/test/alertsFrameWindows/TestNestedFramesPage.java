package test.alertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.alertsFrameWindows.NestedFramesPage;
import test.BaseTest;

public class TestNestedFramesPage extends BaseTest {

    private NestedFramesPage nestedFramesPage;
    private static final String PARENT_TEXT = "Parent frame";
    private static final String CHILD_TEXT = "Child Iframe";

    @BeforeClass
    public void init() {
        nestedFramesPage = new NestedFramesPage(driver);
    }

    @Test(priority = 1)
    public void goToNestedFrames() {
        nestedFramesPage.goTo();
    }

    @Test(priority = 2)
    public void parentFrameTest() {
        Assert.assertTrue(
                nestedFramesPage
                        .parentFrame()
                        .isTextCorrect(NestedFramesPage.FramesAvailable.PARENT, PARENT_TEXT)
        );
    }

    @Test(priority =3)
    public void childFrameTest() {
        Assert.assertTrue(
                nestedFramesPage
                        .childFrame()
                        .isTextCorrect(NestedFramesPage.FramesAvailable.CHILD, CHILD_TEXT)
        );
    }
}
