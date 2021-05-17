package test.widgets;

import objects.widgets.Tabs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestTabs extends HelperClass {

    private Tabs tb;

    @BeforeClass
    public void init() {
        tb = new Tabs(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        tb.go().click();
    }

    @Test(priority = 2)
    public void whatTab() {
        tb.whatB().click();
        Assert.assertEquals(tb.whatB().getAttribute("aria-selected"), "true");
        Assert.assertEquals(tb.whatT().getAttribute("class"), "fade tab-pane active show");
    }

    @Test(priority = 2)
    public void originTab() {
        tb.originB().click();
        Assert.assertEquals(tb.originB().getAttribute("aria-selected"), "true");
        Assert.assertEquals(tb.originT().getAttribute("class"), "fade tab-pane active show");
    }

    @Test(priority = 2)
    public void useTab() {
        tb.useB().click();
        Assert.assertEquals(tb.useB().getAttribute("aria-selected"), "true");
        Assert.assertEquals(tb.useT().getAttribute("class"), "fade tab-pane active show");
    }

    @Test(priority = 2)
    public void moreTab() {
        Assert.assertEquals(tb.moreB().getAttribute("aria-disabled"),"true");
    }
}
