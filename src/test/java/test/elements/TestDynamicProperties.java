package test.elements;

import objects.elements.DynamicProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestDynamicProperties extends HelperClass {

    private DynamicProperties dp;
    private WebElement elem;

    @BeforeClass
    public void init() {
        dp = new DynamicProperties(getDriver());

    }


    @Test(priority = 1)
    public void goToDynamicProperties() {
        dp.goToDp();
    }

   /* @Test(priority = 2)
    public void checkFiveSecondButton() throws InterruptedException {
        elem = dp.checkFiveSec();
        Assert.assertFalse(elem.isEnabled());
        Thread.sleep(5000);
        Assert.assertTrue(elem.isEnabled());
        elem.click();
    }*/

    @Test(priority = 2)
    public void checkFiveSecondButtonExplicit() {
        elem = dp.checkFiveSec();
        Assert.assertFalse(elem.isEnabled());
        WebDriverWait wait = new WebDriverWait(getDriver(), 6);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        Assert.assertTrue(elem.isEnabled());
    }


    @Test(priority = 3)
    public void checkColorChangeButton() {
        elem = dp.checkColor();
        Assert.assertEquals(elem.getAttribute("class"), "mt-4 text-danger btn btn-primary");
    }


    @Test(priority = 3)
    public void checkInvisibleButton() {
        elem = dp.checkInvis();
        Assert.assertTrue(elem.isDisplayed());
    }
}
