package test.elements;

import objects.elements.TextBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestTextBox extends HelperClass {

    private TextBox tb;
    private String fullName = "fullname";
    private String email = "email@dot.com";
    private String address = "adress";
    private String permAddress = "permAdress";

    @BeforeClass
    public void init() {
        tb = new TextBox(getDriver());
    }

    @Test
    public void fillFormAndSubmit() {
        tb.goToTextBox().click();
        this.fillNsubmit();
        Assert.assertEquals("Name:" + fullName, getDriver().findElement(By.xpath("//p[@id='name']")).getText());
        Assert.assertEquals("Email:" + email, getDriver().findElement(By.xpath("//p[@id='email']")).getText());
        Assert.assertEquals("Current Address :" + address, getDriver().findElement(By.xpath("//p[@id='currentAddress']")).getText());
        Assert.assertEquals("Permananet Address :" + permAddress, getDriver().findElement(By.xpath("//p[@id='permanentAddress']")).getText());
    }

    public void fillNsubmit(){
        tb.name().sendKeys(fullName);
        tb.email().sendKeys(email);
        tb.address().sendKeys(address);
        tb.permAddress().sendKeys(permAddress);
        tb.submitButton().click();
    }

}
