package test.elements;

import objects.elements.CheckBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestCheckBox extends HelperClass {

    private CheckBox cb;


    @Test
    public void checkReactBox() {
        cb = new CheckBox(getDriver());
        cb.goToCheckBox();
        cb.checkReact();
        Assert.assertEquals("react",
                getDriver().findElement(By.xpath("//span[@class='text-success']")).getText());
    }
}
