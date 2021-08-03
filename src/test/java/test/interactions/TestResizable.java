package test.interactions;

import objects.interactions.Interactions;
import objects.interactions.Resizable;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestResizable extends BaseTest {

    private Resizable resizablePage;
    private Interactions inter;
    private final static String FIXED_MAX ="width: 500px; height: 300px;";
    private final static String FIXED_MIN ="width: 150px; height: 150px;";

    @BeforeClass
    public void init() {
        resizablePage = new Resizable(driver);
        inter = new Interactions(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goTo() {
        inter.go();
        resizablePage.go();
    }

    @Test(priority = 2)
    public void resizeBoxInside() {
        Assert.assertEquals(
                resizablePage
                        .dragAndDropOffset(resizablePage.getResizeInside(), 350, 150)
                        .getResizableRestrictions()
                        .getAttribute("style"),
                FIXED_MAX
        );
        Assert.assertEquals(
                resizablePage
                        .dragAndDropOffset(resizablePage.getResizeInside(), -400, -400)
                        .getResizableRestrictions()
                        .getAttribute("style"),
                FIXED_MIN
        );
    }

    @Test(priority = 2)
    public void resizeBoxOutside() {
        String originalValue = resizablePage.getResizable().getAttribute("style");

        Assert.assertNotEquals(
                resizablePage
                        .dragAndDropOffset(resizablePage.getResizeOutside(), 350, 150)
                        .getResizable()
                        .getAttribute("style"),
                originalValue
        );
    }

}
