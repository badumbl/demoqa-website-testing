package test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.widgets.SelectMenusPage;
import test.BaseTest;

public class TestSelectMenusPage extends BaseTest {

    private SelectMenusPage selectMenusPage;
    private final static String selectValueOption = "Group 2, option 1";
    private final static String selectOneOption = "Prof.";
    private final static String selectOldOption = "Indigo";
    private final static String selectStandardMultiOption1 = "Saab";
    private final static String selectStandardMultiOption2 = "Audi";
    private final static String selectMulti1 = "Green";
    private final static String selectMulti2 = "Black";

    @BeforeClass
    public void init() {
        selectMenusPage = new SelectMenusPage(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        selectMenusPage.go();
    }

    @Test(priority = 2)
    public void selectValueMenu()  {
        Assert.assertEquals(
                selectMenusPage
                        .selectValue(selectValueOption)
                        .getSelectedValue().getText(),
                selectValueOption
        );
    }

    @Test(priority = 3)
    public void selectOneMenu() {
        Assert.assertEquals(
                selectMenusPage
                        .selectOne(selectOneOption)
                        .getSelectedOne().getText(),
                selectOneOption
        );
    }

    @Test(priority = 4)
    public void oldStyleSelectMenu() {
        selectMenusPage
                .selectOldStyle(selectOldOption);
    }


    @Test(priority = 5)
    public void multiSelectMenu() {
        selectMenusPage
                .multiSelect(selectMulti1, selectMulti2);
    }

    @Test(priority = 6)
    public void standartMultiSelectMenu() {
        selectMenusPage
                .standartMultiChoose(selectStandardMultiOption1, selectStandardMultiOption2);

    }
}
