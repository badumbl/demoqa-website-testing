package test.elements;

import objects.elements.ElementsMenu;
import objects.elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestRadioButton extends BaseTest {

    private RadioButton radioButtonPage;
    private ElementsMenu em;
    private final static String YES_TEXT = "Yes";
    private final static String IMPRESSIVE_TEXT = "Impressive";
    private final static String NO_TEXT = "No";

    @BeforeClass
    public void init() {
        radioButtonPage = new RadioButton(driver);
        em = new ElementsMenu(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goToRadioButton() {
        em.goToElementsMenu();
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
