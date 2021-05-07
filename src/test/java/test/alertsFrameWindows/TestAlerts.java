package test.alertsFrameWindows;

import objects.alertsFrameWindows.Alerts;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;


public class TestAlerts extends HelperClass {

    private Alerts al;
    private String text = "Test for alert text";

    @BeforeClass
    public void init() {
        al = new Alerts(getDriver());
    }

    @Test(priority = 1)
    public void goToAlerts() {
        al.goAlerts();
    }

    @Test(priority = 2)
    public void alertButton() {
        al.alert();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "You clicked a button");
        al.acceptAlert();
    }

    @Test(priority = 2)
    public void alertFiveButton() {
        al.alertFive();
        new WebDriverWait(getDriver(), 6)
                .until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "This alert appeared after 5 seconds");
        al.acceptAlert();
    }

    @Test(priority = 2)
    public void alertConfirmButton() {
        al.alertConfirm();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Do you confirm action?");
        al.acceptAlert();
        Assert.assertEquals(getDriver().findElement(By.xpath("//span[@id='confirmResult']")).getText(), "You selected Ok");
        al.alertConfirm();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Do you confirm action?");
        al.declineAlert();
        Assert.assertEquals(getDriver().findElement(By.xpath("//span[@id='confirmResult']")).getText(), "You selected Cancel");

    }

    @Test(priority = 2)
    public void alertPromptButton() {
        al.alertPrompt();
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Please enter your name");
        getDriver().switchTo().alert().sendKeys(text);
        al.acceptAlert();
        Assert.assertEquals(getDriver().findElement(By.xpath("//span[@id='promptResult']")).getText(),
                "You entered " + text);
    }

}
