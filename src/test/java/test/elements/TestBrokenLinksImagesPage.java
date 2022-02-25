package test.elements;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.elements.BrokenLinksImagesPage;
import test.BaseTest;

public class TestBrokenLinksImagesPage extends BaseTest {

    private BrokenLinksImagesPage brokenLinksImagesPage;

    @BeforeClass
    public void init() {
        brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
    }

    @Test(priority = 1)
    public void goToBrokenLinksAndImages() {
        brokenLinksImagesPage.goToBrokenLinks();
    }


    @Test(priority = 2)
    public void testBrokenLink() {
        RestAssured.baseURI = driver.getCurrentUrl();
        Assert.assertEquals(
                RestAssured
                        .given()
                        .get(brokenLinksImagesPage.brokenLink())
                        .getStatusCode(), 500);
    }
}
