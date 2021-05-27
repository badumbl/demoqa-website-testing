package test.widgets;

import objects.widgets.ProgressBar;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.concurrent.TimeUnit;

public class TestProgressBar extends HelperClass {

    private ProgressBar pb;
    private String desiredProgress = "89%";
    private Wait<WebDriver> wait ;

    @BeforeClass
    public void init() {
        pb = new ProgressBar(getDriver());
        wait = new FluentWait<>(getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
    }

    @Test(priority = 1)
    public void goTo() {
        pb.go().click();
    }

    @Test(priority = 2)
    public void buttonName() {
        Assert.assertEquals(pb.startStopButton().getText(), "Start");
        pb.startStopButton().click();
        Assert.assertEquals(pb.startStopButton().getText(), "Stop");
        wait.until((WebDriver wb) -> pb.resetButton().isDisplayed());
        Assert.assertEquals(pb.resetButton().getText(), "Reset");
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class='progress-bar bg-success']"))
                .getText(), "100%");
        pb.resetButton().click();
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@class='progress-bar bg-info']"))
                .getText(), "0%");

    }

    @Test(priority = 3)
    public void progress() {
        WebElement elem = getDriver().findElement(By.xpath("//div[@class='progress-bar bg-info']"));
        pb.startStopButton().click();
        wait.until((WebDriver wb) -> elem.getText().equals(desiredProgress));
        pb.startStopButton().click();
        Assert.assertEquals(elem.getText(), desiredProgress);
    }
}
