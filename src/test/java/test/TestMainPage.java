package test;

import objects.MainPage;
import org.testng.annotations.Test;


public class TestMainPage extends HelperClass {

    private MainPage mainPage;
    private String element = "Forms";
    private String testLink = "https://demoqa.com/";

    @Test
    public void start() {
        mainPage = new MainPage(getDriver());
        mainPage.init(testLink);
        //Go to element for testing (Elements, Forms, Widgets, etc.)
        mainPage.goToElement(element);
    }

}
