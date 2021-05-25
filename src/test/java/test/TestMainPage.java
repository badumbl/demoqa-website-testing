package test;

import objects.MainPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestMainPage extends HelperClass {

    private MainPage mainPage;
    private String element = "Forms";

    @BeforeClass
    public void init(){
        mainPage = new MainPage(getDriver());
    }

    @Test
    public void start() {
        //Scroll is needed, because footer blocks button on smaller monitors
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,250)");
        //Go to element for testing (Elements, Forms, Widgets, etc.)
        mainPage.goToElement(element).click();
    }

}
