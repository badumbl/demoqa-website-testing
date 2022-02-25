package test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.elements.WebTablesPage;
import test.BaseTest;

public class TestWebTablesPage extends BaseTest {

    private WebTablesPage webTablesPage;
    private final static String FIRST_NAME = "First";
    private final static String LAST_NAME = "Last";
    private final static String EMAIL = "email@email.com";
    private final static String AGE = "21";
    private final static String SALARY = "5000";
    private final static String DEPARTMENT = "dept";
    private final static String EDITED_DEPARTMENT = "department";

    @BeforeClass
    public void init() {
        webTablesPage = new WebTablesPage(driver);
    }

    @Test(priority = 1)
    public void goToWebTables() {
        webTablesPage.goToTables();
    }

    @Test(priority = 2)
    public void addNewPerson() {
        Assert.assertNotNull(
                webTablesPage
                        .register(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT)
                        .findByValue(FIRST_NAME)
        );
    }

    @Test(priority = 3)
    public void editDepartment() {
        Assert.assertNotNull(
                webTablesPage
                        .editDept(DEPARTMENT, EDITED_DEPARTMENT)
                        .findByValue(EDITED_DEPARTMENT)
        );
    }

    @Test(priority = 4)
    public void search() {
        Assert.assertNotNull(
                webTablesPage
                        .search(LAST_NAME)
                        .findByValue(LAST_NAME)
        );
    }

    @Test(priority = 5)
    public void deleteRow() {
        Assert.assertNull(webTablesPage
                .delete(FIRST_NAME)
                .findByValue(FIRST_NAME)
        );
    }
}
