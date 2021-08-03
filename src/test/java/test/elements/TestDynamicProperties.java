package test.elements;

import objects.elements.DynamicProperties;
import objects.elements.ElementsMenu;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestDynamicProperties extends BaseTest {

    private DynamicProperties dynamicPropPage;
    private ElementsMenu em;
    private final static String COLOR = "mt-4 text-danger btn btn-primary";

    @BeforeClass
    public void init() {
        dynamicPropPage = new DynamicProperties(driver);
        em = new ElementsMenu(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goToDynamicProperties() {
        em.goToElementsMenu();
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
