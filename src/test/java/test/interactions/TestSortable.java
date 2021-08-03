package test.interactions;

import objects.interactions.Interactions;
import objects.interactions.SortableObj;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;


public class TestSortable extends BaseTest {

    private SortableObj sortablePage;
    private Interactions inter;
    private final static String FIRST_OBJECT = "One";
    private final static String SECOND_OBJECT = "Two";
    private final static String FIFTH_OBJECT = "Five";

    @BeforeClass
    public void init() {
        sortablePage = new SortableObj(driver);
        inter = new Interactions(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goTo() {
        inter.go();
        sortablePage.go();
    }

    @Test(priority = 2)
    public void sortList() {
        sortablePage
                .goToList()
                .dragAndDrop(sortablePage.getFromList(FIRST_OBJECT),
                        sortablePage.getFromList(FIFTH_OBJECT));

        Assert.assertEquals(sortablePage.getListElements().get(0).getText(), SECOND_OBJECT);
        Assert.assertEquals(sortablePage.getListElements().get(3).getText(), FIFTH_OBJECT);
        Assert.assertEquals(sortablePage.getListElements().get(4).getText(), FIRST_OBJECT);
    }


    @Test(priority = 3)
    public void sortGrid() {
        sortablePage
                .goToGrid()
                .dragAndDrop(sortablePage.getFromGrid(FIRST_OBJECT),
                        sortablePage.getFromGrid(FIFTH_OBJECT));

        Assert.assertEquals(sortablePage.getGridElements().get(0).getText(), SECOND_OBJECT);
        Assert.assertEquals(sortablePage.getGridElements().get(3).getText(), FIFTH_OBJECT);
        Assert.assertEquals(sortablePage.getGridElements().get(4).getText(), FIRST_OBJECT);
    }

}
