package test.elements;

import objects.elements.Buttons;
import objects.elements.ElementsMenu;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestButtons extends BaseTest {

    private Buttons buttonsPage;
    private ElementsMenu em;
    private final static String DOUBLE_CLICK_TEXT = "You have done a double click";
    private final static String RIGHT_CLICK_TEXT = "You have done a right click";
    private final static String SINGLE_CLICK_TEXT = "You have done a dynamic click";

    @BeforeClass
    public void init() {
        buttonsPage = new Buttons(driver);
        em = new ElementsMenu(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goToButtons() {
        em.goToElementsMenu();
        buttonsPage.goButton();
    }

    @Test(priority = 2)
    public void checkDoubleClick() {
        Assert.assertEquals(
                buttonsPage
                        .doubleClick()
                        .getDoubleClickText(),
                DOUBLE_CLICK_TEXT
        );
    }

    @Test(priority = 2)
    public void checkRightClick() {
        Assert.assertEquals(
                buttonsPage
                        .rightClick()
                        .getRightClickText(),
                RIGHT_CLICK_TEXT
        );
    }

    @Test(priority = 2)
    public void checkSingleClick() {
        Assert.assertEquals(
                buttonsPage
                        .singleClick()
                        .getSingleClickText(),
                SINGLE_CLICK_TEXT
        );
    }
}
