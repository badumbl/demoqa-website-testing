package test.alertsFrameWindows;

import objects.alertsFrameWindows.ModalDialogs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestModalDialogs extends HelperClass {

    private ModalDialogs md;
    private String loremIpsum = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    @BeforeClass
    public void init() {
        md = new ModalDialogs(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        waiting(md.go());
        md.go().click();
    }

    @Test(priority = 2)
    public void smallModal() {
        md.small();
        waitForVisible("//*[@class='modal-body']");
        Assert.assertEquals(getDriver().findElement(By.xpath("//*[@class='modal-body']")).getText(),
                "This is a small modal. It has very less content");
        md.close("small");
    }

    @Test(priority = 3)
    public void largeModal() {
        md.large();
        waitForVisible("//*[@class='modal-body']//p");
        Assert.assertEquals(getDriver().findElement(By.xpath("//*[@class='modal-body']//p")).getText(), loremIpsum);
        md.close("large");
    }

    public void waitForVisible(String locator) {
        WebElement elem = getDriver().findElement(By.xpath(locator));
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(elem));
    }

}
