package test.elements;

import io.restassured.RestAssured;
import objects.elements.BrokenLinksImages;
import objects.elements.ElementsMenu;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestBrokenLinksImages extends BaseTest {

    private BrokenLinksImages brokenLinksImagesPage;
    private ElementsMenu em;


    @BeforeClass
    public void init() {
        brokenLinksImagesPage = new BrokenLinksImages(driver);
        em = new ElementsMenu(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goToBrokenLinksAndImages() {
        em.goToElementsMenu();
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
