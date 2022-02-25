package test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.widgets.AccordianPage;
import test.BaseTest;

public class TestAccordianPage extends BaseTest {

    private AccordianPage accordianPage;

    @BeforeClass
    public void init() {
        accordianPage = new AccordianPage(driver);
    }

    @Test(priority = 1)
    public void goTo() {
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
