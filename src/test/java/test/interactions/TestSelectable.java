package test.interactions;

import objects.interactions.SelectableObj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestSelectable extends HelperClass {

    private SelectableObj selob;
    private String firstSelection = "Cras justo odio";
    private String secondSelection = "Morbi leo risus";
    private String firstSelectionGrid = "One";
    private String secondSelectionGrid = "Eight";

    private List<WebElement> list;
    private List<WebElement> grid;

    @BeforeClass
    public void init() {
        selob = new SelectableObj(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        selob.go().click();
    }

    @Test(priority = 2)
    public void checkList() {
        selob.goToList().click();
        list = selob.getList();
        try {
            Objects.requireNonNull(goThroughList(firstSelection, list)).click();
            Objects.requireNonNull(goThroughList(secondSelection, list)).click();
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        Assert.assertEquals(getDriver()
                .findElement(By.xpath("//li[contains(text(),'" + firstSelection + "')]"))
                .getAttribute("class"), "mt-2 list-group-item active list-group-item-action");
        Assert.assertEquals(getDriver()
                .findElement(By.xpath("//li[contains(text(),'" + secondSelection + "')]"))
                .getAttribute("class"), "mt-2 list-group-item active list-group-item-action");
    }

    @Test(priority = 3)
    public void checkGrid() {
        selob.goToGrid().click();
        grid = selob.getGrid();
        try {
            Objects.requireNonNull(goThroughList(firstSelectionGrid, grid)).click();
            Objects.requireNonNull(goThroughList(secondSelectionGrid, grid)).click();
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        Assert.assertEquals(getDriver()
                .findElement(By.xpath("//li[contains(text(),'" + firstSelectionGrid + "')]"))
                .getAttribute("class"), "list-group-item active list-group-item-action");
        Assert.assertEquals(getDriver()
                .findElement(By.xpath("//li[contains(text(),'" + secondSelectionGrid + "')]"))
                .getAttribute("class"), "list-group-item active list-group-item-action");
    }

    private WebElement goThroughList(String name, List<WebElement> theList) {
        for (WebElement elem : theList) {
            if (elem.getText().equals(name)) {
                return elem;
            }
        }
        return null;
    }


}
