package test.widgets;

import objects.widgets.ToolTips;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.concurrent.TimeUnit;

public class TestToolTips extends BaseTest {
/*
    private ToolTips tt;
    private Actions act;
    private Wait<WebDriver> wait;
    private JavascriptExecutor jse;

    @BeforeClass
    public void init() {
        tt = new ToolTips(driver);
        act = new Actions(driver);
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        jse = (JavascriptExecutor) driver;
    }

    @Test(priority = 1)
    public void goTo() {
        //Scroll is needed, because footer blocks button on smaller monitors
        jse.executeScript("window.scrollBy(0,250)");
        tt.go().click();
        wait.until((WebDriver wd) -> ExpectedConditions.visibilityOfAllElements());

    }

    @Test(priority = 2)
    public void hoverOverButton() {
        jse.executeScript("arguments[0].scrollIntoView();", tt.hoverButton());
        act.moveToElement(tt.hoverButton()).perform();
        wait.until((WebDriver wd) -> tt.hoverButtonText().isDisplayed());
        Assert.assertEquals(tt.hoverButtonText().getText(), "You hovered over the Button");
    }

    @Test(priority = 3)
    public void hoverOverTextField() {
        act.moveToElement(tt.hoverField()).perform();
        wait.until((WebDriver wd) -> tt.hoverFieldText().isDisplayed());
        Assert.assertEquals(tt.hoverFieldText().getText(), "You hovered over the text field");
    }

    @Test(priority = 3)
    public void hoverOverLinks() {
        act.moveToElement(tt.hoverLinkOne()).perform();
        wait.until((WebDriver wd) -> tt.hoverLinkOneText().isDisplayed());
        Assert.assertEquals(tt.hoverLinkOneText().getText(), "You hovered over the Contrary");
        act.moveToElement(tt.hoverLinkTwo()).perform();
        wait.until((WebDriver wd) -> tt.hoverLinkTwoText().isDisplayed());
        Assert.assertEquals(tt.hoverLinkTwoText().getText(), "You hovered over the 1.10.32");

    }*/

}
