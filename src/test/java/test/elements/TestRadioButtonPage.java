package test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.elements.RadioButtonPage;
import test.BaseTest;

public class TestRadioButtonPage extends BaseTest {

    private RadioButtonPage radioButtonPage;
    private final static String YES_TEXT = "Yes";
    private final static String IMPRESSIVE_TEXT = "Impressive";
    private final static String NO_TEXT = "No";

    @BeforeClass
    public void init() {
        radioButtonPage = new RadioButtonPage(driver);
    }

    @Test(priority = 1)
    public void goToRadioButton() {
        radioButtonPage.goToRadio();
    }

    @Test(priority = 2)
    public void checkYesButton() {
        Assert.assertTrue(
                radioButtonPage
                        .checkYes()
                        .isTextEquals(YES_TEXT)
        );
    }

    @Test(priority = 2)
    public void checkImpressiveButton() {
        Assert.assertTrue(
                radioButtonPage
                        .checkImpr()
                        .isTextEquals(IMPRESSIVE_TEXT)
        );
    }

    @Test(priority = 2)
    public void checkNoButton() {
        Assert.assertFalse(
                radioButtonPage
                        .checkNo()
                        .isTextEquals(NO_TEXT)
        );
    }
}
