package test.interactions;

import objects.interactions.SortableObj;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.Arrays;
import java.util.List;

public class TestSortable extends HelperClass {

    private SortableObj sor;
    private Actions action;
    private String nameOfFirstObjectFromList = "One";
    private String nameOfSecondObjectFromList = "Five";
    private List<WebElement> list;
    private List<WebElement> grid;

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
        list = sor.fillTheList();
        sor.goToList().click();
        waiting(list.get(0));
        WebElement elem = sor.getFromList(nameOfFirstObjectFromList);
        WebElement elem2 = sor.getFromList(nameOfSecondObjectFromList);
        try {
            action.moveToElement(elem);
            action.dragAndDrop(elem, elem2).perform();
        } catch (NullPointerException nul) {
            System.out.println(Arrays.toString(nul.getStackTrace()));
        }
        Assert.assertEquals(list.get(0).getText(),"Two");
        Assert.assertEquals(list.get(3).getText(),"Five");
        Assert.assertEquals(list.get(4).getText(),"One");
    }

    @Test(priority = 3)
    public void sortGrid() {
        grid = sor.fillTheGrid();
        sor.goToGrid().click();
        waiting(grid.get(0));
        WebElement elem = sor.getFromGrid(nameOfFirstObjectFromList);
        WebElement elem2 = sor.getFromGrid(nameOfSecondObjectFromList);
        try {
            action.moveToElement(elem);
            action.dragAndDrop(elem, elem2).perform();
        } catch (NullPointerException nul) {
            System.out.println(Arrays.toString(nul.getStackTrace()));
        }
        Assert.assertEquals(grid.get(0).getText(),"Two");
        Assert.assertEquals(grid.get(3).getText(),"Five");
        Assert.assertEquals(grid.get(4).getText(),"One");
    }

}
