package test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.widgets.TabsPage;
import test.BaseTest;

public class TestTabsPage extends BaseTest {

    private TabsPage tabsPage;

    @BeforeClass
    public void init() {
        tabsPage = new TabsPage(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        tabsPage.go();
    }

    @Test(priority = 3)
    public void whatTab() {
        Assert.assertTrue(
                tabsPage.whatTab()
                        .isButtonSelected(tabsPage.getWhatButton())
        );
        Assert.assertTrue(tabsPage.isTextVisible(tabsPage.getWhatText()));
    }

    @Test(priority = 2)
    public void originTab() {
        Assert.assertTrue(
                tabsPage
                        .originTab()
                        .isButtonSelected(tabsPage.getOriginButton())
        );
        Assert.assertTrue(tabsPage.isTextVisible(tabsPage.getOriginText()));
    }

    @Test(priority = 4)
    public void useTab() {
        Assert.assertTrue(
                tabsPage
                        .useTab()
                        .isButtonSelected(tabsPage.getUseButton())
        );
        Assert.assertTrue(tabsPage.isTextVisible(tabsPage.getUseText()));
    }

    @Test(priority = 5)
    public void moreTab() {
        Assert.assertFalse(tabsPage.isButtonSelected(tabsPage.getMoreButton()));
    }
}
