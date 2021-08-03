package test.widgets;

import objects.widgets.Slider;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestSlider extends BaseTest {

    private Slider sl;

    @BeforeClass
    public void init() {
        sl = new Slider(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        sl.go().click();
    }

    @Test(priority = 2)
    public void moveSliderTo() {
        new Actions(driver).dragAndDropBy(sl.slider(), 50, 0).perform();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='sliderValue']"))
                .getAttribute("value"),"58");
    }

}
