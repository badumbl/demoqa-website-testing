package test.alertsFrameWindows;

import objects.alertsFrameWindows.BrowserWindows;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.ArrayList;

public class TestBrowserWindows extends HelperClass {

    private BrowserWindows bw;

    @BeforeClass
    public void init() {
        bw = new BrowserWindows(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        waiting(bw.go());
        bw.go().click();
        waiting(bw.newTab());
    }

    @Test(priority = 2)
    public void newTabButton() {
        bw.newTab().click();
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/sample");
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));
    }

    @Test(priority = 2)
    public void newWindowButton() {
        bw.newWindow().click();
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://demoqa.com/sample");
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));
    }

    //TBU
    @Test(priority = 2)
    public void newWindowMessageButton() {
       /* bw.newWindowMessage().click();
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        Assert.assertEquals(getDriver().getCurrentUrl(),"about:blank");
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));*/
    }

}
