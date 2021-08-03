package test.alertsFrameWindows;

import objects.alertsFrameWindows.AlFrWi;
import objects.alertsFrameWindows.BrowserWindows;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;


public class TestBrowserWindows extends BaseTest {

    private BrowserWindows browserWindowsPage;
    private AlFrWi afw;
    private static final String URL_TO_COMPARE = "https://demoqa.com/sample";

    @BeforeClass
    public void init() {
        browserWindowsPage = new BrowserWindows(driver);
        super.passMainPage();
        afw = new AlFrWi(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        afw.go();
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
