package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.MainPage;


public class TestMainPage extends BaseTest {

    private MainPage mainPage;
    private String element = "Forms";

    @BeforeClass
    public void init(){
        mainPage = new MainPage(driver);
    }

    @Test
    public void start() {
        //Go to element for testing (Elements, Forms, Widgets, etc.)
        mainPage.goToElement(element).click();
    }

}
