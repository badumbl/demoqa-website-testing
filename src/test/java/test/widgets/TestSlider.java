package test.widgets;

import objects.widgets.Slider;
import objects.widgets.Widgets;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestSlider extends BaseTest {

    private Slider sliderPage;
    private Widgets wd;

    @BeforeClass
    public void init() {
        wd = new Widgets(driver);
        sliderPage = new Slider(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goTo() {
        wd.go();
        sliderPage.go();
    }

    @Test(priority = 2)
    public void moveSliderTo() {
        Assert.assertEquals(
                sliderPage
                        .moveSlider()
                        .getSliderValue().getAttribute("value"),
                "58"
        );
    }

}
