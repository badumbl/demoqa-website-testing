package test.elements;

import objects.elements.WebTables;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestWebTables extends HelperClass {

    private WebTables wb;
    private String firstName = "First";
    private String lastName = "Last";
    private String email = "email@email.com";
    private String age = "21";
    private String salary = "5000";
    private String department = "dept";
    private String editedDepartment = "department";

    @BeforeClass
    public void init(){
        wb = new WebTables(getDriver());
    }

    @Test(priority = 1)
    public void goToWebTables() {
        wb.goToTables().click();
    }

    @Test(priority = 2)
    public void addAndRegister() {
        wb.addButton().click();
        wb.register(firstName, lastName, email, age, salary, department);
        wb.submitBtn().click();
        Assert.assertEquals(firstName, getDriver().findElement(By.xpath("//div[text()='" + firstName + "']")).getText());
    }

    @Test(priority = 3)
    public void editDepartment() {
        wb.editBtn(department).click();
        wb.editDept(editedDepartment);
        wb.submitBtn().click();
        Assert.assertEquals(editedDepartment, getDriver().findElement(By.xpath("//div[text()='" + editedDepartment + "']")).getText());

    }

    @Test(priority = 4)
    public void search() {
        wb.search().sendKeys(lastName);
        Assert.assertEquals(lastName, getDriver().findElement(By.xpath("//div[text()='" + lastName + "']")).getText());
    }

    @Test(priority = 5)
    public void deleteRow() {
        wb.delete(firstName).click();
        Assert.assertTrue(getDriver().findElements(By.xpath("//div[text()='" + firstName + "']")).isEmpty());
    }
}
