package test.interactions;

import objects.interactions.Interactions;
import objects.interactions.SelectableObj;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

import java.util.Arrays;

public class TestSelectable extends BaseTest {

    private SelectableObj selectablePage;
    private Interactions inter;
    private final static String FIRST_SELECTION = "Cras justo odio";
    private final static String SECOND_SELECTION = "Morbi leo risus";
    private final static String FIRST_SELECTION_GRID = "One";
    private final static String SECOND_SELECTION_GRID = "Eight";
    private final static String SELECTED_CLASS_LIST = "mt-2 list-group-item active list-group-item-action";
    private final static String SELECTED_CLASS_GRID = "list-group-item active list-group-item-action";


    @BeforeClass
    public void init() {
        selectablePage = new SelectableObj(driver);
        inter = new Interactions(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goTo() {
        inter.go();
        selectablePage.go();
    }

    @Test(priority = 2)
    public void checkList() {
        selectablePage.goToList();

        try {
            Assert.assertEquals(
                    selectablePage
                            .chooseElementList(FIRST_SELECTION)
                            .goThroughList(FIRST_SELECTION, selectablePage.getList())
                            .getAttribute("class"),
                    SELECTED_CLASS_LIST
            );
            Assert.assertEquals(
                    selectablePage
                            .chooseElementList(SECOND_SELECTION)
                            .goThroughList(SECOND_SELECTION, selectablePage.getList())
                            .getAttribute("class"),
                    SELECTED_CLASS_LIST
            );
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Test(priority = 3)
    public void checkGrid() {
        try {
            Assert.assertEquals(
                    selectablePage
                            .chooseElementGrid(FIRST_SELECTION_GRID)
                            .goThroughList(FIRST_SELECTION_GRID, selectablePage.getGrid())
                            .getAttribute("class"),
                    SELECTED_CLASS_GRID
            );
            Assert.assertEquals(
                    selectablePage
                            .chooseElementGrid(SECOND_SELECTION_GRID)
                            .goThroughList(SECOND_SELECTION_GRID, selectablePage.getGrid())
                            .getAttribute("class"),
                    SELECTED_CLASS_GRID
            );
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }


}
