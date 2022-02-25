package test.elements;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.elements.LinksPage;
import test.BaseTest;

public class TestLinksPage extends BaseTest {

    private LinksPage linksPage;

    @BeforeClass
    public void init() {
        linksPage = new LinksPage(driver);
        
    }

    @Test(priority = 1)
    public void goToLinks() {
        linksPage.start();
    }

    @Test(priority = 2)
    public void linksNewTab() {
        Assert.assertEquals(
                linksPage
                        .newTabLink()
                        .switchBetweenTabs(1)
                        .getCurrentUrl(),
                BASE_URL
        );
        linksPage.switchBetweenTabs(0);
    }

    @Test(priority = 2)
    public void testApiCalls() {
        Assert.assertEquals(
                super.getStatusCode("created"),
                201
        );
        Assert.assertEquals(
                super.getStatusCode("no-content"),
                204
        );
        Assert.assertEquals(
                super.getStatusCode("bad-request"),
                400
        );
        Assert.assertEquals(
                super.getStatusCode("unauthorized"),
                401
        );
        Assert.assertEquals(
                super.getStatusCode("forbidden"),
                403
        );
        Assert.assertEquals(
                super.getStatusCode("invalid-url"),
                404
        );
    }
}
