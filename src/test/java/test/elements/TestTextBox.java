package test.elements;

import objects.elements.TestBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestTextBox extends HelperClass {

    private TestBox tb;
    private String fullName = "fullname";
    private String email = "email@dot.com";
    private String address = "adress";
    private String permAddress = "permAdress";


    @Test
    public void fillFormAndSubmit() {
        tb = new TestBox(getDriver());
        tb.goToTextBox();
        tb.fillAndSubmit(fullName, email, address, permAddress);
        System.out.println(getDriver().findElement(By.xpath("//p[@id='name']")).getText());
        Assert.assertEquals("Name:" + fullName, getDriver().findElement(By.xpath("//p[@id='name']")).getText());
        Assert.assertEquals("Email:" + email, getDriver().findElement(By.xpath("//p[@id='email']")).getText());
        Assert.assertEquals("Current Address :" + address, getDriver().findElement(By.xpath("//p[@id='currentAddress']")).getText());
        Assert.assertEquals("Permananet Address :" + permAddress, getDriver().findElement(By.xpath("//p[@id='permanentAddress']")).getText());
    }

}
