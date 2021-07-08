package test.bookStoreAppTest;

import objects.bookStoreApp.BookStoreApp;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;
import test.elements.TestElements;

public class TestBookStoreApp extends HelperClass {

    private String name = "test";
    private String lastName = "testlast";
    private String user = "user";
    private String pass = "12345Ab%";
    private TestElements te = new TestElements();
    private BookStoreApp bsa;

    @BeforeClass
    public void init() {
        bsa = new BookStoreApp(getDriver());
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goToElements() throws InterruptedException {
        //Scroll is needed, because footer blocks button on smaller monitors
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,250)");
        bsa.goToBookStoreApp().click();
        bsa.goToLogin().click();
        bsa.createNewUser(name, lastName, user, pass);
    }
}
