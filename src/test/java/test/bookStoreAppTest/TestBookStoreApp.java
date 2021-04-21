package test.bookStoreAppTest;

import objects.bookStoreApp.BookStoreApp;
import org.testng.annotations.Test;
import test.HelperClass;
import test.elements.TestElements;

public class TestBookStoreApp extends HelperClass {

    private TestElements te = new TestElements();
    private BookStoreApp bsa;

    @Test
    public void goToElements() throws InterruptedException {
        bsa = new BookStoreApp(getDriver());
        bsa.goToBookStoreApp();
       // tb.existingUser("username", "password");
        bsa.createNewUser("1","2","3","4");
    }
}
