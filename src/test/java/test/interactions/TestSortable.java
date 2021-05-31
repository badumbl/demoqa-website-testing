package test.interactions;

import objects.interactions.SortableObj;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.Arrays;

public class TestSortable extends HelperClass {

    private SortableObj sor;
    private Actions action;
    private String nameOfFirstObjectFromList = "One";
    private String nameOfSecondObjectFromList = "Five";

    @BeforeClass
    public void init() {
        sor = new SortableObj(getDriver());
        action = new Actions(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        waiting(sor.go());
        sor.go().click();
    }

    @Test(priority = 2)
    public void sortList() {
        sor.goToList().click();
        WebElement elem = sor.getFromList(nameOfFirstObjectFromList);
        WebElement elem2 = sor.getFromList(nameOfSecondObjectFromList);
        try {
            action.dragAndDrop(elem, elem2).perform();
        } catch (NullPointerException nul) {
            System.out.println(Arrays.toString(nul.getStackTrace()));
        }
    }

    @Test(priority = 3)
    public void sortGrid() {
        sor.goToGrid().click();
        WebElement elem = sor.getFromGrid(nameOfFirstObjectFromList);
        WebElement elem2 = sor.getFromGrid(nameOfSecondObjectFromList);
        try {
            action.dragAndDrop(elem, elem2).perform();
        } catch (NullPointerException nul) {
            System.out.println(Arrays.toString(nul.getStackTrace()));
        }
    }

}
