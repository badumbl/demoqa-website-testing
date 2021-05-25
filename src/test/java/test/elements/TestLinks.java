package test.elements;


import objects.elements.Links;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.ArrayList;

public class TestLinks extends HelperClass {

    private Links li;

    @BeforeClass
    public void init() {
        li = new Links(getDriver());
    }

    @Test(priority = 1)
    public void goToLinks()  {
        li.start().click();
    }

    @Test(priority = 2)
    public void linksNewTab() {
        li.newTabLink().click();
        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/");
        getDriver().close();
        getDriver().switchTo().window(tabs2.get(0));
    }
}
