package test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.widgets.AutoCompletePage;
import test.BaseTest;

public class TestAutoCompletePage extends BaseTest {

    private AutoCompletePage autoCompletePage;
    private final static String MULTI_COLORS_CHECKER = "a";
    private final static String SINGLE_COLORS_CHECKER = "r";

    @BeforeClass
    public void init() {
        autoCompletePage = new AutoCompletePage(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        autoCompletePage.go();
    }

    @Test(priority = 2)
    public void multiColorNames() {
        Assert.assertEquals(
                autoCompletePage
                        .multiColor(MULTI_COLORS_CHECKER)
                        .getMultiList().size(),
                3
        );
        Assert.assertEquals(
                autoCompletePage
                        .multiColor(MULTI_COLORS_CHECKER)
                        .selectOption(autoCompletePage.getMultiList(), 1)
                        .multiColor(MULTI_COLORS_CHECKER)
                        .selectOption(autoCompletePage.getMultiList(), 1)
                        .getAutoCompleteMultiField().getText(),
                " option Aqua, selected.\nMagenta\nAqua"
        );
    }

    @Test(priority = 2)
    public void singleColorNames() {
        Assert.assertEquals(
                autoCompletePage
                        .singleColor(SINGLE_COLORS_CHECKER)
                        .selectOption(autoCompletePage.getSingleList(), 2)
                        .getAutoCompleteSingleField().getText(),
                " option Purple, selected.\nPurple"
        );
        Assert.assertEquals(
                autoCompletePage
                        .singleColor(SINGLE_COLORS_CHECKER)
                        .getSingleList().size(),
                3
        );
    }
}
