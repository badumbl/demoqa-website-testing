package test.elements;

import objects.elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestRadioButton extends HelperClass {

    private RadioButton rb;

    @Test(priority = 1)
    public void goToRadioButton() {
        rb = new RadioButton(getDriver());
        rb.goToRadio();
    }
    @Test(priority = 2)
    public void checkYesButton(){
        rb.checkYes();
        Assert.assertEquals("Yes", getDriver().findElement(By.xpath("//span[@class='text-success']")).getText());
    }
    @Test(priority = 3)
    public void checkImpressiveButton(){
        rb.checkImpr();
        Assert.assertEquals("Impressive", getDriver().findElement(By.xpath("//span[@class='text-success']")).getText());
    }

    @Test(priority = 4)
    public void checkNoButton(){
        rb.checkNo();
        Assert.assertNotEquals("No", getDriver().findElement(By.xpath("//span[@class='text-success']")).getText());
    }
}
