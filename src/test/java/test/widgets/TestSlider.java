package test.widgets;

import objects.widgets.Slider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestSlider extends HelperClass {

    private Slider sl;

    @BeforeClass
    public void init() {
        sl = new Slider(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        sl.go();
    }

    @Test(priority = 2)
    public void moveSliderTo() {
        sl.moveTo();
        Assert.assertEquals(getDriver().findElement(By.xpath("//input[@id='sliderValue']"))
                .getAttribute("value"),"58");
    }

}
