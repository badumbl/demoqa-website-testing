package test.elements;

import objects.elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestRadioButton extends HelperClass {

    private RadioButton rb;

    @BeforeClass
    public void init() {
        rb = new RadioButton(getDriver());
    }

    @Test(priority = 1)
    public void goToRadioButton() {
        rb.goToRadio().click();
    }

    @Test(priority = 2)
    public void checkYesButton() {
        rb.checkYes().click();
        Assert.assertEquals("Yes", getDriver().findElement(By.xpath("//span[@class='text-success']")).getText());
    }

    @Test(priority = 2)
    public void checkImpressiveButton() {
        rb.checkImpr().click();
        Assert.assertEquals("Impressive", getDriver().findElement(By.xpath("//span[@class='text-success']")).getText());
    }

    @Test(priority = 2)
    public void checkNoButton() {
        rb.checkNo().click();
        Assert.assertNotEquals("No", getDriver().findElement(By.xpath("//span[@class='text-success']")).getText());
    }
}
