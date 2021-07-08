package test.interactions;

import objects.interactions.Droppable;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestDroppable extends HelperClass {

    private Droppable drop;
    private Actions action;

    @BeforeClass
    public void init() {
        drop = new Droppable(getDriver());
        action = new Actions(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        drop.go().click();
    }

    @Test(priority = 2)
    public void dropSimple() {
        action.dragAndDrop(drop.simpleObj(), drop.simpleTarget()).perform();
        Assert.assertEquals(drop.simpleTarget().getCssValue("background-color"), "rgba(70, 130, 180, 1)");
    }


    @Test(priority = 3)
    public void dropAccept() {
        drop.goAccept().click();
        action.clickAndHold(drop.acceptObj()).moveByOffset(100, 200).perform();
        Assert.assertEquals(drop.acceptTarget().getCssValue("background-color"), "rgba(60, 179, 113, 1)");
        action.release().perform();
        action.dragAndDrop(drop.notAcceptObj(), drop.acceptTarget()).perform();
        Assert.assertEquals(drop.acceptTarget().getAttribute("class"), "drop-box ui-droppable");
        action.dragAndDrop(drop.acceptObj(), drop.acceptTarget()).perform();
        Assert.assertEquals(drop.acceptTarget().getCssValue("background-color"), "rgba(70, 130, 180, 1)");
    }

    @Test(priority = 4)
    public void dropPrevProp() {
        drop.goPrevProp().click();

        action.clickAndHold(drop.dragBox()).moveToElement(drop.outNotGreedy().findElement(By.xpath("//*[text() ='Outer droppable']"))).perform();
        Assert.assertEquals(drop.outNotGreedy().getCssValue("background-color"), "rgba(143, 188, 143, 1)");
        Assert.assertEquals(drop.innerNotGreedy().getCssValue("background-color"), "rgba(60, 179, 113, 1)");
        action.release().perform();

        action.clickAndHold(drop.dragBox()).moveToElement(drop.innerNotGreedy()).perform();
        Assert.assertEquals(drop.outNotGreedy().getCssValue("background-color"), "rgba(143, 188, 143, 1)");
        Assert.assertEquals(drop.innerNotGreedy().getCssValue("background-color"), "rgba(143, 188, 143, 1)");
        action.release().perform();
        Assert.assertEquals(drop.innerNotGreedy().getCssValue("background-color"), "rgba(70, 130, 180, 1)");
        Assert.assertEquals(drop.outNotGreedy().getCssValue("background-color"), "rgba(70, 130, 180, 1)");

        action.dragAndDrop(drop.dragBox(), drop.innerGreedy()).perform();
        Assert.assertEquals(drop.innerGreedy().getCssValue("background-color"), "rgba(70, 130, 180, 1)");
        Assert.assertEquals(drop.outGreedy().getCssValue("background-color"), "rgba(0, 0, 0, 0)");

        action.dragAndDrop(drop.dragBox(), drop.outGreedyChild()).perform();
        Assert.assertEquals(drop.outGreedy().getCssValue("background-color"), "rgba(70, 130, 180, 1)");
        Assert.assertEquals(drop.innerGreedy().getCssValue("background-color"), "rgba(70, 130, 180, 1)");


    }

    @Test(priority = 5)
    public void dropRevert() throws InterruptedException {
        drop.goRevert().click();

        action.dragAndDrop(drop.revertable(), drop.dropBox()).perform();
        Thread.sleep(1000);
        Assert.assertEquals(drop.revertable().getAttribute("style"), "position: relative; left: 0px; top: 0px;");

        action.dragAndDrop(drop.notRevertable(), drop.dropBox()).perform();
        Assert.assertNotEquals(drop.notRevertable().getAttribute("style"), "position: relative; left: 0px; top: 0px;");

    }
}