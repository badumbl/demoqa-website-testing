package test.elements;

import objects.elements.ElementsMenu;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestElements extends HelperClass {


    private ElementsMenu elementsMenu;

    @Test
    public void goToElements() {
        elementsMenu = new ElementsMenu(getDriver());
        elementsMenu.goToElementsMenu();
    }

}
