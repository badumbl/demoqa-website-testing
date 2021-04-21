package test.elements;

import objects.elements.CheckBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestCheckBox extends HelperClass {

    private CheckBox cb;

    //TBD
    @Test
    public void checkReactBox(){
        cb= new CheckBox(getDriver());
        cb.goToCheckBox();
        cb.checkReact();
        System.out.println(getDriver().findElement(By.xpath("//span[contains(text(),'React')]/../span/*[@class='rct-icon rct-icon-check']")).getText());
        /*Assert.assertEquals("rct-icon rct-icon-check",
                getDriver().findElement(By.xpath("//span[contains(text(),'React')]/../span/*[@class='rct-icon rct-icon-check']")).getText());*/
    }
}
