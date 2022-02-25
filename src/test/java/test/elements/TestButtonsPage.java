package test.elements;

import com.google.inject.Inject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.elements.ButtonsPage;
import test.BaseTest;

public class TestButtonsPage extends BaseTest {

    @Inject
    private ButtonsPage buttonsPage;
    private final static String DOUBLE_CLICK_TEXT = "You have done a double click";
    private final static String RIGHT_CLICK_TEXT = "You have done a right click";
    private final static String SINGLE_CLICK_TEXT = "You have done a dynamic click";

    @BeforeClass
    public void init() {
        buttonsPage = new ButtonsPage(driver);
    }

    @Test(priority = 1)
    public void goToButtons() {
        buttonsPage.goButton();
    }

    @Test(priority = 3)
    public void checkDoubleClick() {
        Assert.assertEquals(
                buttonsPage
                        .doubleClick()
                        .getDoubleClickText(),
                DOUBLE_CLICK_TEXT
        );
    }

    @Test(priority = 4)
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
