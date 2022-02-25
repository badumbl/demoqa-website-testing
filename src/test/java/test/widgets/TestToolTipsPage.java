package test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.widgets.ToolTipsPage;
import test.BaseTest;

public class TestToolTipsPage extends BaseTest {

    private ToolTipsPage toolTipsPage;

    @BeforeClass
    public void init() {
        toolTipsPage = new ToolTipsPage(driver);
    }

    @Test(priority = 1)
    public void goTo() {
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

    @Test(priority = 4)
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
