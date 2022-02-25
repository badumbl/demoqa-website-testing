package test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.widgets.SliderPage;
import test.BaseTest;

public class TestSliderPage extends BaseTest {

    private SliderPage sliderPage;

    @BeforeClass
    public void init() {
        sliderPage = new SliderPage(driver);
        
    }

    @Test(priority = 1)
    public void goTo() {
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
