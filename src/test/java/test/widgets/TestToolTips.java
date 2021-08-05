package test.widgets;

import objects.widgets.ToolTips;
import objects.widgets.Widgets;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestToolTips extends BaseTest {

    private ToolTips toolTipsPage;
    private Widgets wd;


    @BeforeClass
    public void init() {
        toolTipsPage = new ToolTips(driver);
        wd = new Widgets(driver);
        super.passMainPage();

    }

    @Test(priority = 1)
    public void goTo() {
        wd.go();
        toolTipsPage.go();
    }

    @Test(priority = 2)
    public void hoverOverButton() {
        Assert.assertEquals(
                toolTipsPage
                        .hoverButton()
                        .getHoverButtonText().getText(),
                "You hovered over the Button"
        );
    }

    @Test(priority = 3)
    public void hoverOverTextField() {
        Assert.assertEquals(
                toolTipsPage
                        .hoverField()
                        .getHoverFieldText().getText(),
                "You hovered over the text field"
        );
    }

    @Test(priority = 3)
    public void hoverOverLinks() {
        Assert.assertEquals(
                toolTipsPage
                        .hoverLinkOne()
                        .getHoverLinkOneText().getText(),
                "You hovered over the Contrary"
        );
        Assert.assertEquals(
                toolTipsPage
                        .hoverLinkTwo()
                        .getHoverLinkTwoText().getText(),
                "You hovered over the 1.10.32"
        );
    }

}
