package test.interactions;

import objects.interactions.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestInteractions extends HelperClass {

    private Interactions inter;

    @BeforeClass
    public void init(){
        inter = new Interactions(getDriver());
        super.passMainPage();
    }

    @Test
    public void goTo(){
        inter.go().click();
       /* new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.attributeContains(getDriver().findElement(By
                        .xpath("//div[contains(text(), 'Interactions')]/../../following-sibling::*")),"class","element-list collapse show"));*/
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[contains(text(),'Sortable')]"))));
       /* Assert.assertEquals(getDriver().findElement(By
                        .xpath("//div[contains(text(), 'Interactions')]/../../following-sibling::*"))
                        .getAttribute("class"),
                "element-list collapse show");*/
    }

}
