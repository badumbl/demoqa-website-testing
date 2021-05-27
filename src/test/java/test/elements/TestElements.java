package test.elements;

import objects.elements.ElementsMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.concurrent.TimeUnit;

public class TestElements extends HelperClass {


    private ElementsMenu elementsMenu;

    @BeforeClass
    public void init(){
        elementsMenu = new ElementsMenu(getDriver());
        super.passMainPage();
    }

    @Test
    public void goToElements() {
        elementsMenu.goToElementsMenu().click();
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until((WebDriver wd) -> getDriver()
                .findElement(By.xpath("//span[contains(text(),'Text Box')]")).isDisplayed());
    }

}
