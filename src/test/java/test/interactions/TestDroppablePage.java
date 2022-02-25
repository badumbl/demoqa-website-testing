package test.interactions;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.interactions.DroppablePage;
import test.BaseTest;

public class TestDroppablePage extends BaseTest {

    private DroppablePage dropPage;
    private Actions action;

    @BeforeClass
    public void init() {
        dropPage = new DroppablePage(driver);
        action = new Actions(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        dropPage.go();
    }

    @Test(priority = 2)
    public void dropSimple() {
        Assert.assertTrue(
                dropPage
                        .dragAndDrop(dropPage.getSimpleObj(), dropPage.getSimpleTarget())
                        .isEquals(dropPage.getSimpleTarget(), "rgba(70, 130, 180, 1)")
        );
    }


    @Test(priority = 3)
    public void dropAccept() {
        Assert.assertTrue(
                dropPage
                        .goAccept()
                        .clickAndHoldOffset(dropPage.getAcceptObj())
                        .isEquals(dropPage.getAcceptTarget(), "rgba(60, 179, 113, 1)")
        );
        action.release().perform();

        Assert.assertEquals(
                dropPage
                        .dragAndDrop(dropPage.getNotAcceptObj(), dropPage.getAcceptTarget())
                        .getAcceptTarget().getAttribute("class"),
                "drop-box ui-droppable");

        Assert.assertTrue(
                dropPage
                        .dragAndDrop(dropPage.getAcceptObj(), dropPage.getAcceptTarget())
                        .isEquals(dropPage.getAcceptTarget(), "rgba(70, 130, 180, 1)")
        );
    }

    @Test(priority = 4)
    public void dropPrevProp() {
        Assert.assertTrue(
                dropPage
                        .goPrevProp()
                        .clickAndHoldToElement(dropPage.getDragBox(), dropPage.getOtherDroppable())
                        .isEquals(dropPage.getOutNotGreedy(), "rgba(143, 188, 143, 1)")
        );
        Assert.assertTrue(
                dropPage
                        .isEquals(dropPage.getInnerNotGreedy(),
                                "rgba(60, 179, 113, 1)")
        );
        action.release().perform();

        Assert.assertTrue(
                dropPage
                        .clickAndHoldToElement(dropPage.getDragBox(), dropPage.getInnerNotGreedy())
                        .isEquals(dropPage.getOutNotGreedy(), "rgba(143, 188, 143, 1)")
        );
        Assert.assertTrue(
                dropPage
                        .isEquals(dropPage.getInnerNotGreedy(),
                                "rgba(143, 188, 143, 1)")
        );
        action.release().perform();
        Assert.assertTrue(
                dropPage
                        .isEquals(dropPage.getInnerNotGreedy(),
                                "rgba(70, 130, 180, 1)")
        );
        Assert.assertTrue(
                dropPage
                        .isEquals(dropPage.getOutNotGreedy(),
                                "rgba(70, 130, 180, 1)")
        );

        Assert.assertTrue(
                dropPage
                        .dragAndDrop(dropPage.getDragBox(), dropPage.getInnerGreedy())
                        .isEquals(dropPage.getInnerGreedy(), "rgba(70, 130, 180, 1)")
        );
        Assert.assertTrue(dropPage.isEquals(dropPage.getOutGreedy(), "rgba(0, 0, 0, 0)"));

        Assert.assertTrue(
                dropPage
                        .dragAndDrop(dropPage.getDragBox(), dropPage.getOutGreedyChild())
                        .isEquals(dropPage.getOutGreedy(), "rgba(70, 130, 180, 1)")
        );
        Assert.assertTrue(dropPage.isEquals(dropPage.getInnerGreedy(), "rgba(70, 130, 180, 1)"));
    }

    @Test(priority = 5)
    public void dropRevert() throws InterruptedException {
        dropPage
                .goRevert()
                .dragAndDrop(dropPage.getRevertable(), dropPage.getDropBox());
        Thread.sleep(1000);

        Assert.assertEquals(
                dropPage
                        .getRevertable().getAttribute("style"),
                "position: relative; left: 0px; top: 0px;"
        );

        Assert.assertNotEquals(
                dropPage
                        .dragAndDrop(dropPage.getNotRevertable(), dropPage.getDropBox())
                        .getNotRevertable().getAttribute("style"),
                "position: relative; left: 0px; top: 0px;"
        );
    }
}