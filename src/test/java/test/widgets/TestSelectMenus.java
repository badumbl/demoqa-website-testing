package test.widgets;

import objects.widgets.SelectMenus;
import objects.widgets.Widgets;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestSelectMenus extends BaseTest {

    private SelectMenus selectMenusPage;
    private Widgets wd;
    private final static String selectValueOption = "Group 2, option 1";
    private final static String selectOneOption = "Prof.";
    private final static String selectOldOption = "Indigo";
    private final static String selectStandardMultiOption1 = "Saab";
    private final static String selectStandardMultiOption2 = "Audi";
    private final static String selectMulti1 = "Green";
    private final static String selectMulti2 = "Black";

    @BeforeClass
    public void init() {
        selectMenusPage = new SelectMenus(driver);
        wd = new Widgets(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goTo() {
        wd.go();
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
