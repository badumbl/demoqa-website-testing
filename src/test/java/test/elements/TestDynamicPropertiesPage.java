package test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.elements.DynamicPropertiesPage;
import test.BaseTest;

public class TestDynamicPropertiesPage extends BaseTest {

    private DynamicPropertiesPage dynamicPropPage;
    private final static String COLOR = "mt-4 text-danger btn btn-primary";

    @BeforeClass
    public void init() {
        dynamicPropPage = new DynamicPropertiesPage(driver);
    }

    @Test(priority = 1)
    public void goToDynamicProperties() {
        dynamicPropPage.goToDp();
    }

    @Test(priority = 2)
    public void checkFiveSecondButtonExplicit() {
        Assert.assertTrue(
                dynamicPropPage
                        .fiveSecondButton()
                        .isEnabled()
        );
    }

    @Test(priority = 3)
    public void checkColorChangeButton() {
        Assert.assertEquals(
                dynamicPropPage
                        .colorButton()
                        .getAttribute("class"),
                COLOR
        );
    }

    @Test(priority = 2)
    public void checkInvisibleButton() {
        Assert.assertTrue(
                dynamicPropPage
                        .invisibleButton()
                        .isDisplayed()
        );
    }
}
