package test.widgets;

import objects.widgets.AutoComplete;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.List;

public class TestAutoComplete extends HelperClass {

    private AutoComplete ac;
    private String multiColorsChecker = "a";
    private String singleColorsChecker = "r";

    @BeforeClass
    public void init() {
        ac = new AutoComplete(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        ac.go();
    }

    @Test(priority = 2)
    public void multiColorNames() {
        List<WebElement> list = ac.multiColor(multiColorsChecker);
        Assert.assertEquals(list.size(), 3);
        ac.selectOption(1);
        list = ac.multiColor(multiColorsChecker);
        ac.selectOption(1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='autoCompleteMultipleContainer']")).getText(),
                " option Aqua, selected.\nMagenta\nAqua");
    }

    @Test(priority = 2)
    public void singleColorNames() {
        List<WebElement> list = ac.singleColor(singleColorsChecker);
        Assert.assertEquals(list.size(), 3);
        ac.selectOption(2);
        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='autoCompleteSingleContainer']")).getText(),
                " option Purple, selected.\nPurple");
    }

}
