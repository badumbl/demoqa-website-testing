package test.alertsFrameWindows;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.alertsFrameWindows.BrowserWindowsPage;
import test.BaseTest;


public class TestBrowserWindowsPage extends BaseTest {

    private BrowserWindowsPage browserWindowsPage;
    private static final String URL_TO_COMPARE = "https://demoqa.com/sample";

    @BeforeClass
    public void init() {
        browserWindowsPage = new BrowserWindowsPage(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        browserWindowsPage.go();
    }

    @Test(priority = 2)
    public void newTabButton() {
        Assert.assertTrue(
                browserWindowsPage
                        .newTab()
                        .isUrlCorrect(URL_TO_COMPARE)
        );
    }

    @Test(priority = 3)
    public void newWindowButton() {
        Assert.assertTrue(
                browserWindowsPage
                        .newWindow()
                        .isUrlCorrect(URL_TO_COMPARE)
        );
    }
}
