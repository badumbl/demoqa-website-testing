package test.widgets;

import objects.widgets.Accordian;
import objects.widgets.Widgets;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestAccordian extends BaseTest {

    private Accordian accordianPage;
    private Widgets wd;

    @BeforeClass
    public void init() {
        accordianPage = new Accordian(driver);
        wd = new Widgets(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goTo() {
        wd.go();
        accordianPage.go();
    }

    @Test(priority = 3)
    public void whatIsLorem() {
        Assert.assertTrue(
                accordianPage
                        .whatIs()
                        .getWhatIsContent()
                        .isDisplayed()
        );
    }

    @Test(priority = 2)
    public void whereDoesLorem() {
        Assert.assertTrue(
                accordianPage
                        .whereDoes()
                        .getWhereDoesContent()
                        .isDisplayed()
        );
    }

    @Test(priority = 2)
    public void whyDoLorem() {
        Assert.assertTrue(
                accordianPage
                        .whyDo()
                        .getWhyDoContent()
                        .isDisplayed()
        );
    }
}
