package test.widgets;

import objects.widgets.Tabs;
import objects.widgets.Widgets;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestTabs extends BaseTest {

    private Tabs tabsPage;
    private Widgets wd;

    @BeforeClass
    public void init() {
        tabsPage = new Tabs(driver);
        wd = new Widgets(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goTo() {
        wd.go();
        tabsPage.go();
    }

    @Test(priority = 3)
    public void whatTab() {
        Assert.assertTrue(
                tabsPage.whatB()
                        .isButtonSelected(tabsPage.getWhatButton())
        );
        Assert.assertTrue(tabsPage.isTextVisible(tabsPage.getWhatText()));
    }

    @Test(priority = 2)
    public void originTab() {
        Assert.assertTrue(
                tabsPage
                        .originB()
                        .isButtonSelected(tabsPage.getOriginButton())
        );
        Assert.assertTrue(tabsPage.isTextVisible(tabsPage.getOriginText()));
    }

    @Test(priority = 4)
    public void useTab() {
        Assert.assertTrue(
                tabsPage
                        .useB()
                        .isButtonSelected(tabsPage.getUseButton())
        );
        Assert.assertTrue(tabsPage.isTextVisible(tabsPage.getUseText()));
    }

    @Test(priority = 5)
    public void moreTab() {
        Assert.assertFalse(tabsPage.isButtonSelected(tabsPage.getMoreButton()));
    }
}
