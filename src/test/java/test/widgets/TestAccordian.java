package test.widgets;

import objects.widgets.Accordian;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestAccordian extends HelperClass {

    private Accordian acc;

    @BeforeClass
    public void init() {
        acc = new Accordian(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        waiting(acc.go());
        acc.go().click();
    }

    @Test(priority = 3)
    public void whatIsLorem() {
        acc.whatIs();
        waitCollapsed("//div[@id='section1Heading']/following-sibling::div");
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[@id='section1Content']//p")).isDisplayed());
    }

    @Test(priority = 2)
    public void whereDoesLorem() {
        acc.whereDoes();
        waitCollapsed("//div[@id='section2Heading']/following-sibling::div");
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[@id='section2Content']//p")).isDisplayed());
    }

    @Test(priority = 2)
    public void whyDoLorem() {
        acc.whyDo();
        waitCollapsed("//div[@id='section3Heading']/following-sibling::div");
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[@id='section3Content']//p")).isDisplayed());
    }

    private void waitCollapsed(String s) {
        WebElement elem = getDriver().findElement(By.xpath(s));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions
                .attributeContains(elem, "class", "collapse show"));
    }


}
