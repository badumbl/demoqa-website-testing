package test.interactions;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.interactions.SortableObjectPage;
import test.BaseTest;


public class TestSortableObjectPage extends BaseTest {

    private SortableObjectPage sortablePage;
    private final static String FIRST_OBJECT = "One";
    private final static String SECOND_OBJECT = "Two";
    private final static String FIFTH_OBJECT = "Five";

    @BeforeClass
    public void init() {
        sortablePage = new SortableObjectPage(driver);
    }

    @Test(priority = 1)
    public void goTo() {
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
